package oop.practice.lab0;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class readFileJSON {
    private static ObjectMapper mapper = new ObjectMapper();
    public List<Alien> readAndMapJsonFile() throws IOException {
        // Load the input.json file from the classpath
        InputStream inputFile = getClass().getClassLoader().getResourceAsStream("input.json");

        if (inputFile == null) {
            System.out.println("File not found! Make sure input.json is in src/main/resources.");
            return new ArrayList<>();
        }

        // Use Jackson ObjectMapper to parse the JSON
        JsonNode jsonData = mapper.readTree(inputFile);

        // Access the "data" array
        JsonNode dataArray = jsonData.get("data");

        if (dataArray != null && dataArray.isArray()) {
            // Map each object in the array to the Alien class
            return mapper.convertValue(dataArray, new TypeReference<List<Alien>>() {});
        } else {
            System.out.println("'data' field is missing or not an array.");
            return new ArrayList<>();
        }
    }
}
