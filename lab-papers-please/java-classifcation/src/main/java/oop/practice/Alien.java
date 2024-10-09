package oop.practice;

import java.util.Arrays;

public class Alien {
    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private String[] traits;

    // Constructor
//    public Alien(int id, boolean isHumanoid, String planet, int age, String[] traits) {
//        this.id = id;
//        this.isHumanoid = isHumanoid;
//        this.planet = planet;
//        this.age = age;
//        this.traits = traits;
//    }

    public Alien(){}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsHumanoid() {
        return isHumanoid;
    }

    public void setHumanoid(boolean isHumanoid) {
        this.isHumanoid = isHumanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getTraits() {
        return traits;
    }

    public void setTraits(String[] traits) {
        this.traits = traits;
    }

    // Method
    public void printAlienInfo() {
        System.out.println("ID: " + id);
        System.out.println("Is Humanoid: " + isHumanoid);
        System.out.println("Planet: " + planet);
        System.out.println("Age: " + age);
        System.out.print("Traits: ");
        if (traits != null) {
            for (String trait : traits) {
                System.out.print(trait + " ");
            }
        } else {
            System.out.print("No Traits");
        }
        System.out.println("\n");
    }
}

