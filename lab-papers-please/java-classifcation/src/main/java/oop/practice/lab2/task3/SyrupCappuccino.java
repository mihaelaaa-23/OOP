package oop.practice.lab2.task3;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    protected final String name = "Syrup Cappuccino";

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
    }

    public SyrupCappuccino makeSyrupCappuccino() {
        System.out.println("Making " + getName());
        printCoffeeDetails();
        return this;
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    public void setSyrup(SyrupType syrup) {
        this.syrup = syrup;
    }

    public String getName() {
        return name;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Adding " + syrup + " syrup");
    }
}

