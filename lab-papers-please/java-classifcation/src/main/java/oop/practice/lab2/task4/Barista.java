package oop.practice.lab2.task4;

import java.util.List;

public class Barista {
    public void takeOrder(List<String> coffeeOrders){
        for (String order : coffeeOrders) {
            Coffee coffee = createOrder(order);
            if (coffee != null) {
                System.out.println("\n☕\uFE0F☕\uFE0F☕\uFE0F");
                switch (order.toLowerCase()) {
                    case "cappuccino":
                        ((Cappuccino) coffee).makeCappuccino();
                        break;
                    case "americano":
                        ((Americano) coffee).makeAmericano();
                        break;
                    case "pumpkin spice latte":
                        ((PumpkinSpiceLatte) coffee).makePumpkinSpiceLatte();
                        break;
                    case "syrup cappuccino":
                        ((SyrupCappuccino) coffee).makeSyrupCappuccino();
                        break;
                    default:
                        System.out.println("Unknown coffee type: " + order);
                        break;
                }
            } else {
                System.out.println("\nSorry, we don't serve " + order + ".");
            }
        }
    }

    private Coffee createOrder(String order){
        switch (order.toLowerCase()){
            case "cappuccino":
                return new Cappuccino(Coffee.Intensity.NORMAL, 150);
            case "americano":
                return new Americano(Coffee.Intensity.STRONG, 150);
            case "pumpkin spice latte":
                return new PumpkinSpiceLatte(Coffee.Intensity.LIGHT, 150, 50);
            case "syrup cappuccino":
                return new SyrupCappuccino(Coffee.Intensity.STRONG, 100, Coffee.SyrupType.POPCORN);
            default:
                return null;
        }
    }
}
