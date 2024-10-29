package oop.practice.lab0;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

public record Universe(
        String name,
        List<JsonNode> individuals
) {}
