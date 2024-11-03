package oop.practice.lab2.task1;

public class Cappuccino extends Coffee{
    protected int mlOfMilk;
    protected final String name = "Cappuccino";

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
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
}
