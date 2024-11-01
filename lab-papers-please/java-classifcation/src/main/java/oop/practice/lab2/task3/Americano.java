package oop.practice.lab2.task3;

public class Americano extends Coffee {
    protected int mlOfWater;
    protected final String name = "Americano";

    public Americano (Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
    }

    public Americano makeAmericano() {
        System.out.println("Making " + getName());
        printCoffeeDetails();
        return this;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public void setMlOfWater(int mlOfWater) {
        this.mlOfWater = mlOfWater;
    }

    public String getName() {
        return name;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Adding " + mlOfWater + " mls of water");
    }
}
