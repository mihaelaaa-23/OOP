package oop.practice.lab3.task5;

public class Main {
    public static void main(String[] args) {

        Scheduler scheduler = new Scheduler("src/main/java/oop/practice/lab3/queue");
        scheduler.schedulePolling(3); // Poll every 3 seconds
        scheduler.scheduleServing(5); // Serve every 5 seconds


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nShutting down program...");
        }));
    }
}
