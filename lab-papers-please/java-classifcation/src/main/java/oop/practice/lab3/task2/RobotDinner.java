package oop.practice.lab3.task2;

public class RobotDinner implements Dineable{
    private static int robotsServed = 0;

    @Override
    public void serveDinner(String carId) {
        robotsServed++;
        System.out.println("Serving Dinner to robots in car: " + carId);
    }

    public static int getRobotsServed() {
        return robotsServed;
    }

    public static void resetRobotsServed() {
        robotsServed = 0;
    }

}
