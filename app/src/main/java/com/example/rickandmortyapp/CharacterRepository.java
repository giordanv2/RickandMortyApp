package com.example.rickandmortyapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import retrofit2.Response;
import retrofit2.Retrofit;


public class CharacterRepository {
    private MutableLiveData<List<Character>> characters;
    private CharacterApi characterApi;

    public CharacterRepository() {
        Retrofit retrofit = RetrofitClient.getClient("https://rickandmortyapi.com/api/");
        characterApi = retrofit.create(CharacterApi.class);
    }
    public LiveData<List<Character>> getCharacters() {
        if (characters == null) {
            characters = new MutableLiveData<List<Character>>();
            loadCharacters();
        }
        return characters;
    }

    private void loadCharacters() {
        characterApi.getCharacters().enqueue(new retrofit2.Callback<CharacterResponse>() {
            @Override
            public void onResponse(retrofit2.Call<CharacterResponse> call, Response<CharacterResponse> response) {
                if (response.isSuccessful()) {
                    CharacterResponse characterResponse = response.body();
                    if (characterResponse != null) {
                        List<Character> characterList = characterResponse.getCharacters();
                        characters.postValue(characterList);
                    }
                } else {
                    // handle error response
                }

            }

            @Override
            public void onFailure(retrofit2.Call<CharacterResponse> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

}
