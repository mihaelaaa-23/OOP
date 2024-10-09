package oop.practice;

public class Alien {
    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private String[] traits;

    // Constructor
    public Alien(int id, boolean isHumanoid, String planet, int age, String[] traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    // Getters
    public int getId() {
        return id;
    }

    public boolean getIsHumanoid() {
        return isHumanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public int getAge() {
        return age;
    }

    public String[] getTraits() {
        return traits;
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

