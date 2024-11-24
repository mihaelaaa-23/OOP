package oop.practice.lab3.task4;
import oop.practice.lab3.task3.CarStation;
import oop.practice.lab3.task1.LinkedQueue;
import oop.practice.lab3.task3.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SemaphoreTest {

    private Semaphore semaphore;

    @BeforeEach
    public void setUp() {
        semaphore = new Semaphore();

        CarStation gasStation = new CarStation(
                carId -> System.out.println("Serving dinner to GAS car: " + carId),
                (carId, consumption) -> System.out.println("Refueling GAS car: " + carId),
                new LinkedQueue<>(10)
        );

        CarStation electricStation = new CarStation(
                carId -> System.out.println("Serving dinner to ELECTRIC car: " + carId),
                (carId, consumption) -> System.out.println("Refueling ELECTRIC car: " + carId),
                new LinkedQueue<>(10)
        );

        semaphore.addCarStation("GAS", gasStation);
        semaphore.addCarStation("ELECTRIC", electricStation);
    }

    @Test
    public void testAddCarStation() {
        assertDoesNotThrow(() -> semaphore.addCarStation("NEW_TYPE",
                new CarStation(carId -> System.out.println("Custom station: " + carId),
                        (carId, consumption) -> System.out.println("Custom refuel: " + carId),
                        new LinkedQueue<>(5))));
    }

    @Test
    public void testRouteCar() {
        semaphore.routeCar(new Car(1,"GAS", "PEOPLE", true,10));
        semaphore.routeCar(new Car(2,"ELECTRIC", "ROBOTS", false,10));

        // Verify that cars are added to the appropriate station queues
        assertEquals(1, semaphore.getGasStationQueueSize(), "GAS Station Queue should have 1 car");
        assertEquals(1, semaphore.getElectricStationQueueSize(), "ELECTRIC Station Queue should have 1 car");

        assertEquals(1, semaphore.getPeopleDiningQueueSize(), "PEOPLE Dining Queue should have 1 car");
        assertEquals(0, semaphore.getRobotDiningQueueSize(), "ROBOTS Dining Queue should be empty");
    }

    @Test
    public void testServeAllCars() {
        semaphore.routeCar(new Car(3,"GAS", "PEOPLE", true,10));
        semaphore.routeCar(new Car(4,"ELECTRIC", "ROBOTS", true,10));
        semaphore.routeCar(new Car(5,"GAS", "ROBOTS", false,10));

        semaphore.serveAllCars();

        assertEquals(0, semaphore.getGasStationQueueSize(), "GAS Station Queue should be empty after serving");
        assertEquals(0, semaphore.getElectricStationQueueSize(), "ELECTRIC Station Queue should be empty after serving");
        assertEquals(0, semaphore.getPeopleDiningQueueSize(), "PEOPLE Dining Queue should be empty after serving");
        assertEquals(0, semaphore.getRobotDiningQueueSize(), "ROBOTS Dining Queue should be empty after serving");
    }

    @Test
    public void testDisplayAllQueues() {
        semaphore.routeCar(new Car(6,"GAS", "PEOPLE", true,10));
        semaphore.routeCar(new Car(7,"ELECTRIC", "ROBOTS", true,10));

        assertDoesNotThrow(semaphore::displayAllQueues);
    }

    @Test
    public void testGetStats() {
        semaphore.routeCar(new Car(8,"GAS", "PEOPLE", true,10));
        semaphore.routeCar(new Car(9,"GAS", "ROBOTS", false,10));
        semaphore.routeCar(new Car(10,"ELECTRIC", "ROBOTS", true,10));

        Map<String, Integer> stats = semaphore.getStats();

        assertEquals(2, stats.get("GAS Cars served"), "GAS cars served should be 2");
        assertEquals(1, stats.get("ELECTRIC Cars served"), "ELECTRIC cars served should be 1");
        assertEquals(1, stats.get("PEOPLE Served Dinner"), "PEOPLE should be served dinner");
        assertEquals(1, stats.get("ROBOTS Served Dinner"), "ROBOTS should be served dinner");
        assertEquals(2, stats.get("DINING cars"), "DINING cars should be 2");
        assertEquals(1, stats.get("NON-DINING cars"), "NON-DINING cars should be 1");
    }


}
