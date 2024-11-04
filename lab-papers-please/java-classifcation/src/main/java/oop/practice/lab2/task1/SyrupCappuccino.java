package oop.practice.lab2.task1;

public class SyrupCappuccino extends Cappuccino{
    private SyrupType syrup;
    protected final String name = "Syrup Cappuccino";

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
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
}

