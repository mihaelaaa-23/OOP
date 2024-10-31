package oop.practice.lab2.task1;

public class Americano extends Coffee {
    protected int mlOfWater;
    protected final String name = "Americano";

    public Americano (Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
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
}
