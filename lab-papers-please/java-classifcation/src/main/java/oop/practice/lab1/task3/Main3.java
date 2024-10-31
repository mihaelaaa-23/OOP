package oop.practice.lab1.task3;

import oop.practice.lab1.task1.Display;

public class Main3 {
    public static void main(String[] args) {
        Display m1 = new Display(2560, 1600, 226, "13inch Macbook");
        Display m2 = new Display(3024, 1964, 254, "14inch Macbook");
        Display m3 = new Display(3456, 2234, 254, "16inch Macbook");

        Assistant assistant = new Assistant("Tech Assistant");

        assistant.assignDisplay(m1);
        assistant.assignDisplay(m2);
        assistant.assignDisplay(m3);

        //assistant compares displays
        assistant.assist();
        assistant.buyDisplay(m2);

        //buy the same display to see the output
        assistant.assist();
        assistant.buyDisplay(m2);

        assistant.assist();
        assistant.buyDisplay(m1);

        assistant.assist();
        assistant.buyDisplay(m3);
    }
}
