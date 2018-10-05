package com.pokemon.android.mypokedex;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PokemonLab {
    private static PokemonLab sPokemonLab;
    private List<Pokemon> mPokemons;


    private TextView mPokemonTextView;
    private Pokemon[] mPokemonBank = new Pokemon[]{
            new Pokemon("001", "Bulbasaur", "2'04\"", "15.2 lbs", "Seed Pokemon", "45", "49", "49","65", "65","45"),
            new Pokemon("002", "Ivysaur", "3'03\"", "28.7 lbs", "Seed Pokemon", "60", "62", "63","80", "80","60"),
            new Pokemon("003", "Venusaur", "6'07\"", "220.5 lbs", "Seed Pokemon", "80", "82", "83","100", "100","80"),
            new Pokemon("004", "Charmander", "2'00\"", "18.7 lbs", "Lizard Pokemon", "39", "52", "43","60", "50","65"),
            new Pokemon("005", "Charmeleon", "3'07\"", "41.9 lbs", "Flame Pokemon", "58", "64", "58","80", "65","80"),
            new Pokemon("006", "Charizard", "5'07\"", "199.5 lbs", "Flame Pokemon", "78", "84", "78","109", "85","100"),
            new Pokemon("007", "Squirtle", "1'08\"", "19.8 lbs", "Tiny Turtle Pokemon", "44", "48", "65","50", "64","43"),
            new Pokemon("008", "Wartortle", "3'03\"", "49.6 lbs", "Turtle Pokemon", "59", "63", "80","65", "80","58"),
            new Pokemon("009", "Blastoise", "5'03\"", "18.5 lbs", "Shellfish Pokemon", "79", "83", "100","85", "105","78"),
            new Pokemon("010", "Caterpie", "1'00\"", "6.4 lbs", "Worm Pokemon", "45", "30", "35","20", "20","45")};

    public static PokemonLab get(Context context) {
        if (sPokemonLab == null) {
            sPokemonLab = new PokemonLab(context);
        }
        return sPokemonLab;
    }

    private PokemonLab(Context context) {
        mPokemons = new ArrayList<>();
        for (int i = 0; i < mPokemonBank.length; i++) {
            mPokemons.add(mPokemonBank[i]);
        }
    }

    public List<Pokemon> getPokemons() {
        return mPokemons;
    }

    public Pokemon getPokemon(UUID id) {
        for (Pokemon pokemon : mPokemons) {
            if (pokemon.getUniqueID().equals(id)) {
                return pokemon;
            }
        }
        return null;
    }
}
