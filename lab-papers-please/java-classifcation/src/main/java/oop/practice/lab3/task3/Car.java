package oop.practice.lab3.task3;

public class Car {
    private String type;
    private String passengerType;
    private boolean wantsDinner;

    public Car(String type, String passengerType, boolean wantsDinner) {
        this.type = type;
        this.passengerType = passengerType;
        this.wantsDinner = wantsDinner;
    }

    public String getType() {
        return type;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public boolean isWantsDinner() {
        return wantsDinner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", passengerType='" + passengerType + '\'' +
                ", wantsDinner=" + wantsDinner +
                '}';
    }
}
