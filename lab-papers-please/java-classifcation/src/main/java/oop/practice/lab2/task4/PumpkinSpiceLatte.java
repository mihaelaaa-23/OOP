package oop.practice.lab2.task4;

class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;
    protected final String name = "Pumpkin Spice Latte";

    public PumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(coffeeIntensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public PumpkinSpiceLatte makePumpkinSpiceLatte() {
        super.makeCappuccino();
        System.out.println("Adding " + mgOfPumpkinSpice + " mgs of pumpkin spice");
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
        System.out.println(getName() + " pumpkin spice: " + mgOfPumpkinSpice + " mgs");
    }
}
