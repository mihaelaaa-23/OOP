package oop.practice.lab2.task3;

public class Cappuccino extends Coffee {
    protected int mlOfMilk;
    protected final String name = "Cappuccino";

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
    }

    public Cappuccino makeCappuccino() {
        printCoffeeDetails();
        super.makeCoffee();
        System.out.println("Adding " + mlOfMilk + " mls of milk");
        return this;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }

    public String getName() {
        return name;
    }

    @Override
    public void printCoffeeDetails(){
        super.printCoffeeDetails();
        System.out.println(getName() + " milk: " + mlOfMilk + " ml");
    }
}
