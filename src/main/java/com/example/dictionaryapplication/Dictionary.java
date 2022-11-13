package com.example.dictionaryapplication;

import java.util.*;

public class Dictionary {
    private Map<String, String> translations;
    private List<String> words;

    public Dictionary() {
        this.translations = new HashMap<>();
        this.words = new ArrayList<>();

        add("Wasser", "water");
        add("Ei", "egg");
        add("heute", "today");
        add("schlafen", "sleep");
        add("Apfel", "apple");
        add("Haus", "house");
    }

    public String get(String word) {
        return this.translations.get(word);
    }

    public void add(String word, String translation) {
        if (!this.translations.containsKey(word))
            this.words.add(word);

        this.translations.putIfAbsent(word, translation);
    }

    public String getRandomWord() {
        Random rand = new Random();
        return this.words.get(rand.nextInt(this.words.size()));
    }
}
