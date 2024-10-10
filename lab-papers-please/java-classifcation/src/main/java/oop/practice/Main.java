package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    InputStream inputFile = Main.class.getClassLoader().getResourceAsStream("input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    List<Alien> aliens = new ArrayList<>();
    for (JsonNode entry : data) {
      Alien alien = mapper.treeToValue(entry, Alien.class);
      aliens.add(alien);
    }

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    List<String> classificationLog = new ArrayList<>();

    for (Alien alien : aliens) {
      alien.printAlienInfo();  // Display alien info

      String classification = null;

      classification = classifyAlien(alien, starWars, hitchhikers, marvel, rings, mapper);

      // Log the classification
      if (classification != null) {
        classificationLog.add("Alien ID " + alien.getId() + " classified as: " + classification);
      } else {
        classificationLog.add("Alien ID " + alien.getId() + " could not be classified.");
      }
    }

    File outputDir = new File("src/main/resources/output");
    if (!outputDir.exists()) {
      outputDir.mkdirs();  // Create output directory if it doesn't exist
    }

    mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
    mapper.writeValue(new File("src/main/resources/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);
    mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);

    System.out.println("\n--- Universe Classification ---");
    for (String logEntry : classificationLog) {
      System.out.println(logEntry);
    }
  }

  private static String classifyAlien(Alien alien, Universe starWars, Universe hitchhikers, Universe marvel, Universe rings, ObjectMapper mapper) throws IOException {
    String classification = null;

    // Lord of the Rings Universe Classification
    if ("Earth".equalsIgnoreCase(alien.getPlanet())) {
      if (alien.getIsHumanoid() && alien.hasTrait("BLONDE") && alien.hasTrait("POINTY_EARS")) {
        rings.individuals().add(mapper.valueToTree(alien));
        classification = "Lord of the Rings (Elf)";
      } else if (alien.getIsHumanoid() && alien.hasTrait("SHORT") && alien.hasTrait("BULKY")) {
        rings.individuals().add(mapper.valueToTree(alien));
        classification = "Lord of the Rings (Dwarf)";
      } else if (alien.getIsHumanoid() && alien.getAge() > 200) {
        rings.individuals().add(mapper.valueToTree(alien));
        classification = "Lord of the Rings (Elf - High Age Predicted)";
      } else if (alien.hasTrait("BLONDE") && alien.hasTrait("TALL")) {
        rings.individuals().add(mapper.valueToTree(alien));
        classification = "Lord of the Rings (Elf - Predicted)";
      } else {
        rings.individuals().add(mapper.valueToTree(alien));
        classification = "Lord of the Rings (Dwarf - Predicted)";
      }
    }
    // Star Wars
    else if (!alien.getIsHumanoid() && "Kashyyyk".equalsIgnoreCase(alien.getPlanet())) {
      starWars.individuals().add(mapper.valueToTree(alien));
      classification = "StarWars (Wookie)";
    } else if (!alien.getIsHumanoid() && "Endor".equalsIgnoreCase(alien.getPlanet())) {
      starWars.individuals().add(mapper.valueToTree(alien));
      classification = "StarWars (Ewok)";
    } else if (alien.hasTrait("HAIRY") && alien.hasTrait("TALL") && alien.getAge() <= 400) {
      starWars.individuals().add(mapper.valueToTree(alien));
      classification = "StarWars (Wookie - Predicted)";
    } else if (alien.hasTrait("SHORT") && alien.hasTrait("HAIRY") && alien.getAge() <= 60) {
      starWars.individuals().add(mapper.valueToTree(alien));
      classification = "StarWars (Ewok - Predicted)";
    }

    // Marvel Universe
    else if (alien.getIsHumanoid() && "Asgard".equalsIgnoreCase(alien.getPlanet())) {
      marvel.individuals().add(mapper.valueToTree(alien));
      classification = "Marvel (Asgardian)";
    } else if (alien.hasTrait("BLONDE") && alien.hasTrait("TALL") && alien.getAge() <= 5000) {
      marvel.individuals().add(mapper.valueToTree(alien));
      classification = "Marvel (Asgardian - Predicted)";
    }

    // Hitchhiker's Universe
    else if (alien.getIsHumanoid() && "Betelgeuse".equalsIgnoreCase(alien.getPlanet())) {
      hitchhikers.individuals().add(mapper.valueToTree(alien));
      classification = "Hitchhiker's (Betelgeusian)";
    } else if (alien.hasTrait("EXTRA_ARMS") || alien.hasTrait("EXTRA_HEAD")) {
      hitchhikers.individuals().add(mapper.valueToTree(alien));
      classification = "Hitchhiker's (Betelgeusian - Predicted)";
    } else if (!alien.getIsHumanoid() && (alien.hasTrait("GREEN") || alien.hasTrait("BULKY"))) {
      hitchhikers.individuals().add(mapper.valueToTree(alien));
      classification = "Hitchhiker's (Vogon - Predicted)";
    }

    // fallback for humanoids with BULKY Trait
    else if (alien.getIsHumanoid() && alien.hasTrait("BULKY")) {
      rings.individuals().add(mapper.valueToTree(alien));
      classification = "Lord of the Rings (Dwarf - Predicted)";
    }

    // fallback for very high ages (for Elves)
    else if (alien.getIsHumanoid() && alien.getAge() > 1000) {
      rings.individuals().add(mapper.valueToTree(alien));
      classification = "Lord of the Rings (Elf - High Age Predicted)";
    }
    return classification;
  }

  record Universe(
          String name,
          List<JsonNode> individuals
  ) {
  }
}
