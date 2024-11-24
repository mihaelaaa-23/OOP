package oop.practice.lab3.task5;
import oop.practice.lab3.task1.LinkedQueue;
import oop.practice.lab3.task3.Car;
import oop.practice.lab3.task3.CarStation;
import oop.practice.lab3.task2.ElectricStation;
import oop.practice.lab3.task2.GasStation;
import oop.practice.lab3.task2.PeopleDinner;
import oop.practice.lab3.task2.RobotDinner;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private final String queueDirectory;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ScheduledExecutorService pollingExecutor = Executors.newSingleThreadScheduledExecutor();
    private final ScheduledExecutorService servingExecutor = Executors.newSingleThreadScheduledExecutor();

    private final CarStation gasStation;
    private final CarStation electricStation;

    public Scheduler(String queueDirectory) {
        this.queueDirectory = queueDirectory;

        this.gasStation = new CarStation(
                new RobotDinner(),
                new GasStation(),
                new LinkedQueue<>(30)
        );

        this.electricStation = new CarStation(
                new PeopleDinner(),
                new ElectricStation(),
                new LinkedQueue<>(30)
        );
    }

    private void pollQueueDirectory() {
        File directory = new File(queueDirectory);
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Invalid queue directory: " + queueDirectory);
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".json"));
        if (files != null) {
            for (File file : files) {
                try {
                    Car car = objectMapper.readValue(file, Car.class);

                    if ("PEOPLE".equals(car.getPassengerType())) {
                        PeopleDinner.countPeople();
                    } else if ("ROBOTS".equals(car.getPassengerType())) {
                        RobotDinner.countRobot();
                    }

                    if ("GAS".equals(car.getType())) {
                        gasStation.addCar(car);
                    } else if ("ELECTRIC".equals(car.getType())) {
                        electricStation.addCar(car);
                    } else {
                        System.err.println("Unknown car type: " + car.getType());
                    }

//                    System.out.println("Processed car ID: " + car.getId());
                    Files.delete(Paths.get(file.getPath()));

                    if (car.getId() == 30) {
//                        System.out.println("30 cars processed. Completing remaining tasks...");
                        shutdown();
                        return;
                    }
                } catch (Exception e) {
                    System.err.println("Error processing file: " + file.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    public void schedulePolling(int intervalSeconds) {
        pollingExecutor.scheduleAtFixedRate(this::pollQueueDirectory, 0, intervalSeconds, TimeUnit.SECONDS);
    }

    public void scheduleServing(int intervalSeconds) {
        servingExecutor.scheduleAtFixedRate(() -> {
            System.out.println("\n\uD83D\uDE97Serving cars \uD83D\uDE97");
            gasStation.serveCars();
            electricStation.serveCars();
        }, 0, intervalSeconds, TimeUnit.SECONDS);
    }

    public void shutdown() {
        try {
//            System.out.println("Shutting down scheduler...");
            pollingExecutor.shutdown();
            servingExecutor.shutdown();

            if (!pollingExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                pollingExecutor.shutdownNow();
            }
            if (!servingExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                servingExecutor.shutdownNow();
            }

            // Ensure all cars in queues are served
//            System.out.println("Serving all remaining cars...");
            gasStation.serveCars();
            electricStation.serveCars();

            // Print final statistics
            printStats();

//            System.out.println("Scheduler shut down successfully.");
        } catch (InterruptedException e) {
            System.err.println("Error during shutdown. Forcing termination...");
            pollingExecutor.shutdownNow();
            servingExecutor.shutdownNow();
        }
    }

    public void printStats() {
        int electricCarsServed = ElectricStation.getElectricCarsServed();
        int gasCarsServed = GasStation.getGasCarsServed();
        int peopleServedDinner = PeopleDinner.getPeopleServed();
        int robotsServedDinner = RobotDinner.getRobotsServed();
        int totalPeople = PeopleDinner.getTotalPeople();
        int totalRobots = RobotDinner.getTotalRobots();
        int totalDining = peopleServedDinner + robotsServedDinner;
        int totalNotDining = (electricCarsServed + gasCarsServed) - totalDining;
        int electricConsumption = ElectricStation.getElectricConsumption();
        int gasConsumption = GasStation.getGasConsumption();

        String stats = String.format(
                "{ \"ELECTRIC\": %d, \"GAS\": %d, \"PEOPLE\": %d, \"ROBOTS\": %d, \"DINING\": %d, \"NOT_DINING\": %d, " +
                        "\"CONSUMPTION\": { \"ELECTRIC\": %d, \"GAS\": %d } }",
                electricCarsServed,
                gasCarsServed,
                totalPeople,
                totalRobots,
                totalDining,
                totalNotDining,
                electricConsumption,
                gasConsumption
        );

        System.out.println();
        System.out.println(stats);
    }
}
