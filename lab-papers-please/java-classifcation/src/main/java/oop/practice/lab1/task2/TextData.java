package oop.practice.lab1.task2;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String fileName, String text) {
//        this.fileName = fileName;
        setFileName(fileName);
        this.text = text;
        processText();
    }

    private void setFileName(String fileName) {
        var parts = fileName.split("[/]");
        this.fileName = parts[parts.length - 1];
    }

    private void processText(){
        numberOfVowels = countVowels();
        numberOfConsonants = countConsonants();
        numberOfLetters = countLetters();
        numberOfSentences = countSentences();
        longestWord = findLongestWord();

    }

    private int countVowels(){
        return (int) text.toLowerCase().chars().filter(c -> "aeiou".indexOf(c) != -1).count();
    }

    private int countConsonants(){
        return (int) text.toLowerCase().chars().filter(c -> "bcdfghjklmnpqrstvwxyz".indexOf(c) != -1).count();
    }

    private int countLetters() {
        return text.replaceAll("[^a-zA-Z]", "").length();
    }

    private int countSentences() {
        return text.split("[.!?]").length;
    }

    private String findLongestWord(){
        String[] words = text.split("[\\s+]"); //splits words by spaces
        String longestWord = "";
        for (String word : words){
            word = word.replaceAll("[^a-zA-Z-]", "");
            if (word.length() > longestWord.length()){
                longestWord = word;
            }
        }
        return longestWord;
    }

    public void printTextData() {
        System.out.println("File: "+ fileName);
        System.out.println("Vowels: " + numberOfVowels);
        System.out.println("Consonants: " + numberOfConsonants);
        System.out.println("Letters: " + numberOfLetters);
        System.out.println("Sentences: " + numberOfSentences);
        System.out.println("Longest word: " + longestWord);
    }
}
