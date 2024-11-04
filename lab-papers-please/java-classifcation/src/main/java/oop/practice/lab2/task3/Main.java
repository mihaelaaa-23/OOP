package oop.practice.lab2.task3;

public class Main {
    public static void main(String[] args) {
        Americano americano = new Americano(Coffee.Intensity.NORMAL, 150);
        americano.makeAmericano();

        System.out.println("\n---\n");

        Cappuccino cappuccino = new Cappuccino(Coffee.Intensity.NORMAL, 150);
        cappuccino.makeCappuccino();

        System.out.println("\n---\n");

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Coffee.Intensity.STRONG,100, Coffee.SyrupType.POPCORN);
        syrupCappuccino.makeSyrupCappuccino();

        System.out.println("\n---\n");

        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Coffee.Intensity.STRONG, 100, 50);
        pumpkinSpiceLatte.makePumpkinSpiceLatte();
    }
}
