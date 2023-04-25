package com.example.rickandmortyapp;

import java.util.List;

public class CharacterResponse {
    private List<Character> results;

    public List<Character> getCharacters() {
        return results;
    }

    public void setCharacters(List<Character> characters) {
        this.results = characters;
    }
}
