package oop.practice.lab1;
public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public void compareSize(Display m) {
        if (this.width * this.height > m.width * m.height) {
            System.out.println(this.model + " has a bigger size than " + m.model);
        } else if (this.width * this.height < m.width * m.height) {
            System.out.println(m.model + " has a bigger size than " + this.model);
        } else {
            System.out.println(this.model + " and " + m.model + " have the same size.");
        }
    }

    public void compareSharpness(Display m) {
        if (this.ppi > m.ppi) {
            System.out.println(this.model + " is sharper than " + m.model);
        } else if (this.ppi < m.ppi) {
            System.out.println(m.model + " is sharper than " + this.model);
        } else {
            System.out.println(this.model + " and " + m.model + " have the same sharpness.");
        }
    }

    public void compareWithMonitor(Display m) {
        compareSize(m);
        compareSharpness(m);
    }
}
