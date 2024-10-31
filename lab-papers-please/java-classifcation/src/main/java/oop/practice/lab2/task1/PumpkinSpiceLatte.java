package oop.practice.lab2.task1;

public class PumpkinSpiceLatte extends Cappuccino{
    private int mgOfPumpkinSpice;
    protected final String name = "Pumpkin Spice Latte";

    public PumpkinSpiceLatte(Intensity coffeeIntensity, int mltrOfMilk, int mgOfPumpkinSpice) {
        super(coffeeIntensity, mltrOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    public void setMgOfPumpkinSpice(int mltrOfMilk) {
        this.mgOfPumpkinSpice = mltrOfMilk;
    }

    public String getName() {
        return name;
    }
}
