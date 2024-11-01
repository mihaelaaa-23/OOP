package oop.practice.lab2;
import java.util.Arrays;
import oop.practice.lab2.task4.Barista;

public class Main {
    public static void main(String[] args) {
        Barista barista = new Barista();
        barista.makeCoffee(Arrays.asList("Americano","Pumpkin Spice Latte","Cappuccino","Syrup Cappuccino"));
    }
}
