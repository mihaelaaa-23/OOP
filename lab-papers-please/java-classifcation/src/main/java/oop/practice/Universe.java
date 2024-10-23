package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

public record Universe(
        String name,
        List<JsonNode> individuals
) {}
