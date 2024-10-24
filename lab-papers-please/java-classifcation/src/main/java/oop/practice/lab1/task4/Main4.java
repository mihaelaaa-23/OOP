package oop.practice.lab1.task4;

import oop.practice.lab1.task2.FileReader;
import oop.practice.lab1.task2.TextData;

import java.io.IOException;

public class Main4 {
    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("Please provide at least one file path.");
            return;
        }

        for (String filePath : args){

            try {
                FileReader fileReader = new FileReader();
                String fileContent = fileReader.readFileIntoString(filePath);

                TextData textData = new TextData(filePath, fileContent);

                textData.printTextData();
            } catch (IOException e) {
                System.out.println("Error reading file: " + " - " + e.getMessage());
            }
            System.out.println("----------------------------------------");
        }
    }
}
