package oop.practice.lab2.task3;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;
    protected final String name = "Pumpkin Spice Latte";

    public PumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(coffeeIntensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public PumpkinSpiceLatte makePumpkinSpiceLatte() {
        System.out.println("Making " + getName());
        printCoffeeDetails();
        return this;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    public void setMgOfPumpkinSpice(int mlOfMilk) {
        this.mgOfPumpkinSpice = mlOfMilk;
    }

    public String getName() {
        return name;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Adding " + mgOfPumpkinSpice + " mgs of pumpkin spice");
    }
}
