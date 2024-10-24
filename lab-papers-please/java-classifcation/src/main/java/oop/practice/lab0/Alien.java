package oop.practice.lab0;

import java.util.Arrays;

public class Alien {
    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private String[] traits;


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

    public boolean hasTrait(String trait) {
        if (traits == null) {
            return false;  // If traits array is null, return false
        }
        return Arrays.asList(traits).contains(trait);  // Check if trait exists in the array
    }
}

