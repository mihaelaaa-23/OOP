package oop.practice.lab3.task3;

public class Car {
    private String type;
    private boolean wantsDinner;

    public Car(String type, boolean wantsDinner) {
        this.type = type;
        this.wantsDinner = wantsDinner;
    }

    public String getType() {
        return type;
    }

    public boolean isWantsDinner() {
        return wantsDinner;
    }
}
