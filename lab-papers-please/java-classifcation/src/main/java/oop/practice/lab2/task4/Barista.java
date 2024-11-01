package oop.practice.lab2.task4;

import java.util.List;

public class Barista {
    public void makeCoffee(List<String> coffeeOrders) {
        for (String order : coffeeOrders) {
            switch (order) {
                case "Cappuccino":
                    System.out.println("\n☕\uFE0F☕\uFE0F☕\uFE0F");
                    makeCappuccino(Coffee.Intensity.NORMAL, 150);
                    break;
                case "Americano":
                    System.out.println("\n☕\uFE0F☕\uFE0F☕\uFE0F");
                    makeAmericano(Coffee.Intensity.STRONG, 150);
                    break;
                case "Pumpkin Spice Latte":
                    System.out.println("\n\uD83C\uDF83\uD83C\uDF83\uD83C\uDF83");
                    makePumpkinSpiceLatte(Coffee.Intensity.LIGHT, 150, 50);
                    break;
                case "Syrup Cappuccino":
                    System.out.println("\n☕\uFE0F☕\uFE0F☕\uFE0F");
                    makeSyrupCappuccino(Coffee.Intensity.STRONG, 100, Coffee.SyrupType.POPCORN);
                    break;
            }
        }
    }

    private void makeCappuccino(Coffee.Intensity intensity, int mlOfMilk) {
        Cappuccino cappuccino = new Cappuccino(intensity, mlOfMilk);
        cappuccino.makeCappuccino();
    }

    private void makeAmericano(Coffee.Intensity intensity, int mlOfMilk) {
        Americano americano = new Americano(intensity, mlOfMilk);
        americano.makeAmericano();
    }

    private void makePumpkinSpiceLatte(Coffee.Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
        pumpkinSpiceLatte.makePumpkinSpiceLatte();
    }

    private void makeSyrupCappuccino(Coffee.Intensity intensity, int mlOfMilk, Coffee.SyrupType syrup) {
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(intensity, mlOfMilk, syrup);
        syrupCappuccino.makeSyrupCappuccino();
    }

}
