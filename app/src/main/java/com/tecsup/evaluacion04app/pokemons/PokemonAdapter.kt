package com.tecsup.evaluacion04app.pokemons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.evaluacion04app.network.Pokemon

class PokemonAdapter(val list: List<Pokemon>): RecyclerView.Adapter<PokemonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = list[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int = list.size
}