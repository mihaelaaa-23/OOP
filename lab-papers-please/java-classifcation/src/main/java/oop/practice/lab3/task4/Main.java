package oop.practice.lab3.task4;

import oop.practice.lab3.task1.LinkedQueue;
import oop.practice.lab3.task3.Car;
import oop.practice.lab3.task3.CarStation;
import oop.practice.lab3.task2.ElectricStation;
import oop.practice.lab3.task2.GasStation;
import oop.practice.lab3.task2.PeopleDinner;
import oop.practice.lab3.task2.RobotDinner;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();

        CarStation gasStation = new CarStation(
                new RobotDinner(),
                new GasStation(),
                new LinkedQueue<>(10)
        );

        CarStation electricStation = new CarStation(
                new PeopleDinner(),
                new ElectricStation(),
                new LinkedQueue<>(10)
        );

        semaphore.addCarStation("GAS", gasStation);
        semaphore.addCarStation("ELECTRIC", electricStation);

        Car[] cars = {
                new Car(1, "GAS", "PEOPLE", true, 30),
                new Car(2, "ELECTRIC", "ROBOTS", false, 20),
                new Car(3, "GAS", "ROBOTS", true, 40),
                new Car(4, "ELECTRIC", "PEOPLE", true, 25),
                new Car(5, "GAS", "ROBOTS", false, 15),
                new Car(6, "ELECTRIC", "PEOPLE", false, 35),
                new Car(7, "GAS", "PEOPLE", true, 10),
                new Car(8, "ELECTRIC", "ROBOTS", true, 50)
        };

        for (Car car : cars) {
            semaphore.routeCar(car);
        }

        System.out.println("\nQueues before serving:");
        semaphore.displayAllQueues();

        System.out.println("\nServing all cars:");
        semaphore.serveAllCars();

        System.out.println("\nFinal Stats:");
        semaphore.getStats().forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
