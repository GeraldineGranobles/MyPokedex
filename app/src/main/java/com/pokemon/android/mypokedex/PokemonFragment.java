package com.pokemon.android.mypokedex;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

public class PokemonFragment extends Fragment {
    private Pokemon mPokemon;
    private TextView mNumber;
    private TextView mName;
    private TextView mHeight;
    private TextView mWeight;
    private TextView mCategory;
    private TextView mHP;
    private TextView mAttack;
    private TextView mDefense;
    private TextView mSpecialAttack;
    private TextView mSpecialDefense;
    private TextView mSpeed;
    private ImageView mImage;
    private Integer[] imageName = {
            R.drawable.bulbasaur,R.drawable.ivysaur,R.drawable.venusaur,
            R.drawable.charmander,R.drawable.charmeleon,R.drawable.charizard,
            R.drawable.squirtle,R.drawable.wartortle,R.drawable.blastoise,
            R.drawable.caterpie };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID pokemonNumber = (UUID) getActivity().getIntent().getSerializableExtra(PokedexActivity.EXTRA_POKEMON_NUMBER);
        mPokemon = PokemonLab.get(getActivity()).getPokemon(pokemonNumber);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pokemon, container, false);

        mImage = v.findViewById(R.id.pokemon_sprite_image);
        Integer i = Integer.valueOf(mPokemon.getNumber()) - 1;
        Drawable image = getResources().getDrawable(imageName[i]);
        mImage.setImageDrawable(image);
        mNumber = v.findViewById(R.id.pokemon_number);
        mNumber.setText("#" + mPokemon.getNumber());
        mName = v.findViewById(R.id.pokemon_name);
        mName.setText(mPokemon.getName());
        mHeight = v.findViewById(R.id.pokemon_height);
        mHeight.setText("Height: " + mPokemon.getHeight());
        mWeight = v.findViewById(R.id.pokemon_weight);
        mWeight.setText("Weight: " + mPokemon.getWeight());
        mCategory = v.findViewById(R.id.pokemon_category);
        mCategory.setText("Category: " + mPokemon.getCategory());
        mHP = v.findViewById(R.id.pokemon_hp);
        mHP.setText("HP: " + mPokemon.getHP());
        mAttack = v.findViewById(R.id.pokemon_attack);
        mAttack.setText("Attack: " + mPokemon.getAttack());
        mDefense = v.findViewById(R.id.pokemon_defense);
        mDefense.setText("Defense: " + mPokemon.getDefense());
        mSpecialAttack = v.findViewById(R.id.pokemon_spa);
        mSpecialAttack.setText("Special Attack: " + mPokemon.getSpecialAttack());
        mSpecialDefense = v.findViewById(R.id.pokemon_spd);
        mSpecialDefense.setText("Special Defense: " + mPokemon.getSpecialDefense());
        mSpeed = v.findViewById(R.id.pokemon_speed);
        mSpeed.setText("Speed: " + mPokemon.getSpeed());

        return v;
    }
}