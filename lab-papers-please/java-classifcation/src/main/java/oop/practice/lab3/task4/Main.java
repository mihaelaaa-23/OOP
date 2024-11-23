package oop.practice.lab3.task4;

import oop.practice.lab3.task3.Car;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();

        // Simulate cars arriving
        Car car1 = new Car("ELECTRIC", "PEOPLE", false);
        Car car2 = new Car("GAS", "PEOPLE", true);
        Car car3 = new Car("GAS", "ROBOTS", true);
        Car car4 = new Car("ELECTRIC", "ROBOTS", true);

        System.out.println("Processing cars...");
        semaphore.routeCar(car1);
        semaphore.routeCar(car2);
        semaphore.routeCar(car3);
        semaphore.routeCar(car4);

        System.out.println("\nDisplaying queues:");
        semaphore.displayAllQueues();

        System.out.println("\nServing all cars...");
        semaphore.serveAllCars();

        System.out.println("\nFinal Stats:");
        Map<String, Integer> stats = semaphore.getStats();
        stats.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
