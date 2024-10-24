package oop.practice.lab0;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
      alien.printAlienInfo();

      String classification = classifyAlien(alien, starWars, hitchhikers, marvel, rings, mapper);

      // Log the classification
      if (classification != null) {
        classificationLog.add("Alien ID " + alien.getId() + " classified as: " + classification);
      } else {
        classificationLog.add("Alien ID " + alien.getId() + " could not be classified.");
      }
    }

    View view = new View();
    view.writeToFile(starWars, "starwars.json");
    view.writeToFile(hitchhikers, "hitchhiker.json");
    view.writeToFile(marvel, "marvel.json");
    view.writeToFile(rings, "rings.json");

    System.out.println("\n--- Encoded JSON for StarWars ---");
    System.out.println(view.encodeToJson(starWars));

    System.out.println("\n--- Universe Classification ---");
    for (String logEntry : classificationLog) {
      System.out.println(logEntry);
    }
  }

  private static String classifyAlien(Alien alien, Universe starWars, Universe hitchhikers, Universe marvel, Universe rings, ObjectMapper mapper) {
    String classification = null;

    // Lord of the Rings
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
}
