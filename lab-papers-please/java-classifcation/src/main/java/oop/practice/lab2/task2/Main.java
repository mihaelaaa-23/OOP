package oop.practice.lab2.task2;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Coffee(Coffee.Intensity.NORMAL);
        Cappuccino cappuccino = new Cappuccino(Coffee.Intensity.STRONG, 50);
        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Coffee.Intensity.STRONG, 60, 20);
        Americano americano = new Americano(Coffee.Intensity.LIGHT, 150);
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Coffee.Intensity.NORMAL, 70, Coffee.SyrupType.VANILLA);

        coffee.printCoffeeDetails();
        System.out.println();

        cappuccino.printCoffeeDetails();
        System.out.println();

        pumpkinSpiceLatte.printCoffeeDetails();
        System.out.println();

        americano.printCoffeeDetails();
        System.out.println();

        syrupCappuccino.printCoffeeDetails();
    }
}
