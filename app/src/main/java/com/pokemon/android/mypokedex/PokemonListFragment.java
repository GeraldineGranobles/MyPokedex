package com.pokemon.android.mypokedex;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class PokemonListFragment extends Fragment {

    private RecyclerView mPokemonRecyclerView;
    private PokemonAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);
        mPokemonRecyclerView = (RecyclerView) view.findViewById(R.id.pokemon_recycler_view);
        mPokemonRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        PokemonLab pokemonLab = PokemonLab.get(getActivity());
        List<Pokemon> pokemons = pokemonLab.getPokemons();
        mAdapter = new PokemonAdapter(pokemons);
        mPokemonRecyclerView.setAdapter(mAdapter);
    }

    private class PokemonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mNameTextView;
        private TextView mIDTextView;
        private Pokemon mPokemon;
        private ImageView mImage;
        private Integer[] spriteName = {
                R.drawable.bulbasaur_sprite,R.drawable.ivysaur_sprite,R.drawable.venusaur_sprite,
                R.drawable.charmander_sprite,R.drawable.charmeleon_sprite,R.drawable.charizard_sprite,
                R.drawable.squirtle_sprite,R.drawable.wartortle_sprite,R.drawable.blastoise_sprite,
                R.drawable.caterpie_sprite };


        public PokemonHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.pokemon_list,parent,false));
            itemView.setOnClickListener(this);
            mNameTextView = (TextView) itemView.findViewById(R.id.pokemon_name);
            mIDTextView = (TextView)  itemView.findViewById(R.id.pokemon_number);
            mImage = itemView.findViewById(R.id.pokemon_image);
        }

        public void onClick(View view) {
            Intent intent =  PokedexActivity.newIntent(getActivity(), mPokemon.getUniqueID());
            startActivity(intent);
        }

        public void bind(Pokemon pokemon) {
            mPokemon = pokemon;
            mNameTextView.setText(mPokemon.getName());
            mIDTextView.setText("#" + mPokemon.getNumber());
            Integer i = Integer.valueOf(mPokemon.getNumber()) - 1;
            Drawable image = getResources().getDrawable(spriteName[i]);
            mImage.setImageDrawable(image);
        }
    }

    private class PokemonAdapter extends RecyclerView.Adapter<PokemonHolder> {
        private List<Pokemon> mPokemons;
        public PokemonAdapter(List<Pokemon> pokemons) {
            mPokemons = pokemons;
        }

        @Override
        public PokemonHolder
        onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new PokemonHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(PokemonHolder holder, int position) {
            Pokemon pokemon = mPokemons.get(position);
            holder.bind(pokemon);
        }
        @Override
        public int getItemCount() {
            return mPokemons.size();
        }
    }
}