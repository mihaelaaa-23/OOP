package oop.practice.lab1.task1;

public class Main {
    public static void main(String[] args) {
        Display m1 = new Display(2560, 1600, 226, "13inch Macbook");
        Display m2 = new Display(3024, 1964, 254, "14inch Macbook");
        Display m3 = new Display(3456, 2234, 254, "16inch Macbook");

        m1.compareWithMonitor(m2);
        m1.compareWithMonitor(m3);
        m2.compareWithMonitor(m3);
    }
}