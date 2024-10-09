package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();

//    File inputFile = new File("src/main/resources/test-input.json");
    InputStream inputFile = Main.class.getClassLoader().getResourceAsStream("test-input.json");

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

    Scanner scanner = new Scanner(System.in);
    for (Alien alien : aliens) {
      alien.printAlienInfo(); // Print alien info for user to decide
      System.out.println("Which universe should this alien belong to?");
      String userInput = scanner.nextLine();
      switch (userInput) {
        case "1":
          starWars.individuals().add(mapper.valueToTree(alien));
          break;
        case "2":
          hitchhikers.individuals().add(mapper.valueToTree(alien));
          break;
        case "3":
          marvel.individuals().add(mapper.valueToTree(alien));
          break;
        case "4":
          rings.individuals().add(mapper.valueToTree(alien));
          break;
        default:
          System.out.println("Invalid input, skipping...");
      }
    }

    scanner.close();

//    for (JsonNode entry : data) {
//      String entryAsString = entry.toString();
//      System.out.println(entryAsString);
//      String userInput = scanner.nextLine();
//      switch (userInput) {
//        case "1":
//          starWars.individuals().add(entry);
//          break;
//        case "2":
//          hitchhikers.individuals().add(entry);
//          break;
//        case "3":
//          marvel.individuals().add(entry);
//          break;
//        case "4":
//          rings.individuals().add(entry);
//          break;
//        default:
//          System.out.println("Invalid input");
//      }
//    }


    File outputDir = new File("src/main/resources/output");
    if (!outputDir.exists()) {
      outputDir.mkdirs();  // Create the output directory if it doesn't exist
    }

    mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
    mapper.writeValue(new File("src/main/resources/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);
    mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);

    System.out.println("\nAliens with even IDs:");
    List<Alien> evenIdAliens = aliens.stream()
            .filter(alien -> alien.getId() % 2 == 0)
            .collect(Collectors.toList());
    evenIdAliens.forEach(Alien::printAlienInfo);

    System.out.println("\nAliens with odd IDs:");
    List<Alien> oddIdAliens = aliens.stream()
            .filter(alien -> alien.getId() % 2 != 0)
            .collect(Collectors.toList());
    oddIdAliens.forEach(Alien::printAlienInfo);
  }
}

record Universe(
    String name,
    List<JsonNode> individuals
) { }
