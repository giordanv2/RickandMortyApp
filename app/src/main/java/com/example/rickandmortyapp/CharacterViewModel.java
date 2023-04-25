package com.example.rickandmortyapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

public class CharacterViewModel extends ViewModel {

    private LiveData<List<Character>> characters;
    private CharacterRepository repository;

    public CharacterViewModel() {
        repository = new CharacterRepository();
        characters = repository.getCharacters();
    }

    public LiveData<List<Character>> getCharacters() {
        return characters;
    }
}
