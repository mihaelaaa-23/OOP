package oop.practice;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.IOException;

public class readFileJSON {
    public void readAndPrintJsonFile() throws IOException {
        InputStream inputFile = getClass().getClassLoader().getResourceAsStream("input.json");

        if (inputFile == null) {
            System.out.println("File not found! Make sure test-input.json is in src/main/resources.");
            return;
        }

        // Jackson ObjectMapper to parse the JSON
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.readTree(inputFile);

        System.out.println("Full JSON Data: ");
        System.out.println(jsonData.toPrettyString());  // Pretty print the full JSON content
    }
}
