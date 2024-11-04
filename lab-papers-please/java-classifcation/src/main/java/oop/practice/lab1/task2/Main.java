package oop.practice.lab1.task2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("Please provide the correct filepath.");
            return;
        }
        String filePath = args[0];

        try{
            FileReader fileReader = new FileReader();
            String fileContent = fileReader.readFileIntoString(filePath);

            TextData textData = new TextData(filePath, fileContent);
            textData.printTextData();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
