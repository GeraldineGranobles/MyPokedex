package com.pokemon.android.mypokedex;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class PokedexActivity extends SingleFragmentActivity {
    public static final String EXTRA_POKEMON_NUMBER = "com.pokemon.android.mypokedex.EXTRA_POKEMON_NUMBER";
    public static Intent newIntent(Context packageContext, UUID pokemonID) {
        Intent intent = new Intent(packageContext, PokedexActivity.class);
        intent.putExtra(EXTRA_POKEMON_NUMBER , pokemonID);
        return intent;
    }

    protected Fragment createFragment() {
        return new PokemonFragment();
    }
}
