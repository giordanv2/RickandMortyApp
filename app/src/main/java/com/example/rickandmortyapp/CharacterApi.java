package com.example.rickandmortyapp;

import retrofit2.Call;
import retrofit2.http.GET;
public interface CharacterApi {
    @GET("character")
    Call<CharacterResponse> getCharacters();
}

