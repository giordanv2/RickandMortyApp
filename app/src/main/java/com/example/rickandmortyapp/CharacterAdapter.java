package com.example.rickandmortyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.bumptech.glide.Glide;
import com.example.rickandmortyapp.CharacterAdapter;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private List<Character> characters;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.character_image);
            nameTextView = itemView.findViewById(R.id.character_name);
        }
    }

    public CharacterAdapter(List<Character> characters) {
        this.characters = characters;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.nameTextView.setText(character.getName());
        Glide.with(holder.itemView.getContext()).load(character.getImage()).into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return characters.size();
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }


}

