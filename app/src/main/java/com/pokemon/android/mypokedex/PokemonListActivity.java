package com.pokemon.android.mypokedex;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class PokemonListActivity extends SingleFragmentActivity {

    @Override protected Fragment createFragment() {
        return new PokemonListFragment();
    }
}
