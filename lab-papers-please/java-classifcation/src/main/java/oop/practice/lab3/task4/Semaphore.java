package oop.practice.lab3.task4;

import oop.practice.lab3.task1.LinkedQueue;
import oop.practice.lab3.task1.Queue;
import oop.practice.lab3.task3.Car;
import oop.practice.lab3.task3.CarStation;

import java.util.HashMap;
import java.util.Map;

public class Semaphore {

    private final Queue<Car> gasStationQueue = new LinkedQueue<>(10);
    private final Queue<Car> electricStationQueue = new LinkedQueue<>(10);
    private final Queue<Car> peopleDiningQueue = new LinkedQueue<>(10);
    private final Queue<Car> robotDiningQueue = new LinkedQueue<>(10);

    private final Map<String, Integer> carTypeCount = new HashMap<>();
    private final Map<String, Integer> passengerTypeCount = new HashMap<>();
    private final Map<String, CarStation> carStations = new HashMap<>();

    private int diningCount = 0;
    private int nonDiningCount = 0;

    public Semaphore() {
        // Initialize counts
        carTypeCount.put("GAS", 0);
        carTypeCount.put("ELECTRIC", 0);
        passengerTypeCount.put("PEOPLE", 0);
        passengerTypeCount.put("ROBOTS", 0);
    }

    public void addCarStation(String type, CarStation carStation) {
        carStations.put(type, carStation);
    }

    public void routeCar(Car car) {
        CarStation station = carStations.get(car.getType());
        if (station != null) {
            station.addCar(car);
            carTypeCount.put(car.getType(), carTypeCount.get(car.getType()) + 1);
        } else {
            System.out.println("No Car Station available for " + car.getType() + " cars.");
        }

        if ("GAS".equals(car.getType())) {
            gasStationQueue.enqueue(car);
        } else if ("ELECTRIC".equals(car.getType())) {
            electricStationQueue.enqueue(car);
        }

        if (car.isWantsDinner()) {
            diningCount++;
            if ("PEOPLE".equals(car.getPassengerType())) {
                peopleDiningQueue.enqueue(car);
                passengerTypeCount.put("PEOPLE", passengerTypeCount.get("PEOPLE") + 1);
            } else if ("ROBOTS".equals(car.getPassengerType())) {
                robotDiningQueue.enqueue(car);
                passengerTypeCount.put("ROBOTS", passengerTypeCount.get("ROBOTS") + 1);
            }
        } else {
            nonDiningCount++;
        }
    }

    public void serveAllCars() {
        serveQueue(gasStationQueue, "Refueling GAS car: ");
        serveQueue(electricStationQueue, "Refueling ELECTRIC car: ");
        serveQueue(peopleDiningQueue, "Serving dinner to PEOPLE in car: ");
        serveQueue(robotDiningQueue, "Serving dinner to ROBOTS in car: ");
    }

    private void serveQueue(Queue<Car> queue, String actionMessage) {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            System.out.println(actionMessage + car);
        }
    }

    public void displayAllQueues() {
        System.out.println("GAS Station Queue: ");
        displayQueue(gasStationQueue);

        System.out.println("\nELECTRIC Station Queue: ");
        displayQueue(electricStationQueue);

        System.out.println("\nPEOPLE Dining Queue: ");
        displayQueue(peopleDiningQueue);

        System.out.println("\nROBOTS Dining Queue: ");
        displayQueue(robotDiningQueue);
    }

    private void displayQueue(Queue<Car> queue) {
        Queue<Car> tempQueue = new LinkedQueue<>(queue.size());
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            System.out.println(car);
            tempQueue.enqueue(car);
        }
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }
    }

    public Map<String, Integer> getStats() {
        Map<String, Integer> resultStats = new HashMap<>();
        resultStats.put("GAS Cars served", carTypeCount.getOrDefault("GAS", 0));
        resultStats.put("ELECTRIC Cars served", carTypeCount.getOrDefault("ELECTRIC", 0));
        resultStats.put("PEOPLE Served Dinner", passengerTypeCount.getOrDefault("PEOPLE", 0));
        resultStats.put("ROBOTS Served Dinner", passengerTypeCount.getOrDefault("ROBOTS", 0));
        resultStats.put("DINING cars", diningCount);
        resultStats.put("NON-DINING cars", nonDiningCount);
        return resultStats;
    }

    public int getGasStationQueueSize() {
        return gasStationQueue.size();
    }

    public int getElectricStationQueueSize() {
        return electricStationQueue.size();
    }

    public int getPeopleDiningQueueSize() {
        return peopleDiningQueue.size();
    }

    public int getRobotDiningQueueSize() {
        return robotDiningQueue.size();
    }
}
