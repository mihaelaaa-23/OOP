package oop.practice.lab2;
import oop.practice.lab2.task4.Barista;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Barista barista = new Barista();
        List<String> coffeeList = Arrays.asList("Americano","Cappuccino","Pumpkin Spice Latte","Syrup Cappuccino","Latte");
        barista.takeOrder(coffeeList);
    }
}
