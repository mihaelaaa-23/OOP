package oop.practice.lab0;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class View {
    private final ObjectMapper mapper = new ObjectMapper();

    public void writeToFile(Universe universe, String filename) throws IOException {
        File outputDir = new File("lab-papers-please/java-classifcation/src/main/resources/output");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        File outputFile = new File(outputDir, filename);
        mapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, universe);  // write to JSON
    }

    //  encode a Universe object as a JSON string
    public String encodeToJson(Universe universe) throws IOException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(universe);
    }
}
