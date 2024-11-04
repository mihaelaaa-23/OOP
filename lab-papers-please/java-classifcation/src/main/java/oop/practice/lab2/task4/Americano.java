package oop.practice.lab2.task4;

class Americano extends Coffee {
    protected int mlOfWater;
    protected final String name = "Americano";

    public Americano (Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
    }

    public Americano makeAmericano() {
        printCoffeeDetails();
        super.makeCoffee();
        System.out.println("Adding " + mlOfWater + " mls of water");
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
        System.out.println(getName() + " water: " + mlOfWater + " ml");
    }
}
