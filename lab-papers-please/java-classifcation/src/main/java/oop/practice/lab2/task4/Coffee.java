package oop.practice.lab2.task4;

class Coffee {
    public enum Intensity {
        LIGHT, NORMAL, STRONG
    }

    public enum SyrupType {
        MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN
    }

    protected Intensity coffeeIntensity;
    protected final String name = "Coffee";

    protected Coffee(Intensity coffeeIntensity){
        this.coffeeIntensity = coffeeIntensity;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public void setCoffeeIntensity(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public String getName() {
        return name;
    }

    public void makeCoffee() {
        System.out.println("\nMaking ✨" + getName() + " ✨");
        System.out.println("Intensity set to " + coffeeIntensity);
    }

    public void printCoffeeDetails() {
        System.out.println("Coffee intensity: " + coffeeIntensity);
    }
}
