package oop.practice.lab3.task3;

import oop.practice.lab3.task1.LinkedQueue;
import oop.practice.lab3.task1.Queue;
import oop.practice.lab3.task2.Dineable;
import oop.practice.lab3.task2.Refuelable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarStationTest {

    private Queue<Car> carQueue;
    private CarStation carStation;

    @BeforeEach
    public void setUp() {
        carQueue = new LinkedQueue<>(5);

        Dineable diningService = carId -> System.out.println("Serving dinner to: " + carId);
        Refuelable refuelingService = carId -> System.out.println("Refueling: " + carId);

        carStation = new CarStation(diningService, refuelingService, carQueue);
    }

    @Test
    public void testAddCar() {
        Car car = new Car("GAS", true);
        carStation.addCar(car);

        assertFalse(carQueue.isEmpty());
        assertEquals(1, carQueue.size());
        assertEquals(car, carQueue.peek());
    }

    @Test
    public void testServeCars() {
        carStation.addCar(new Car("GAS", true));       // Wants dinner
        carStation.addCar(new Car("ELECTRIC", false)); // No dinner

        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }

    @Test
    public void testAllCarsWantDinner() {
        // Add cars that all want dinner
        carStation.addCar(new Car("GAS", true));
        carStation.addCar(new Car("ELECTRIC", true));
        carStation.addCar(new Car("GAS", true));

        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }

    @Test
    public void testNoCarsWantDinner() {
        carStation.addCar(new Car("GAS", false));
        carStation.addCar(new Car("ELECTRIC", false));

        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }

    @Test
    public void testServeEmptyQueue() {
        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should remain empty when there are no cars to serve");
    }


    @Test
    public void testServeLargeNumberOfCars() {
        for (int i = 1; i <= 5; i++) {
            carStation.addCar(new Car("GAS", i % 2 == 0)); // Alternate dinner requests
        }

        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }

    @Test
    public void testMixedCars() {
        carStation.addCar(new Car("GAS", true));       // Wants dinner
        carStation.addCar(new Car("ELECTRIC", false)); // No dinner
        carStation.addCar(new Car("GAS", false));      // No dinner
        carStation.addCar(new Car("ELECTRIC", true));  // Wants dinner

        carStation.serveCars();

        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }


    @Test
    public void testQueueOverflow() {
        for (int i = 1; i <= 5; i++) {
            carStation.addCar(new Car("GAS", false));
        }

        assertThrows(IllegalStateException.class, () -> carStation.addCar(new Car("ELECTRIC", true)),
                "Adding a car to a full queue should throw an exception");
    }

}
