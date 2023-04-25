package com.example.rickandmortyapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CharacterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        adapter = new CharacterAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        CharacterViewModel viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);

        viewModel.getCharacters().observe(this, characters -> adapter.setCharacters(characters));
    }
}
