package com.tecsup.evaluacion04app.pokemons

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.evaluacion04app.R
import com.tecsup.evaluacion04app.network.Pokemon

class PokemonViewHolder (inflater: LayoutInflater, parent: ViewGroup):
RecyclerView.ViewHolder(inflater.inflate(R.layout.item_pokemon, parent, false)){

    private var textName: TextView? = null
    private var textUrl: TextView? = null

    init {
        textName = itemView.findViewById(R.id.textName)
        textUrl = itemView.findViewById(R.id.textUrl)
    }

    fun bind(pokemon: Pokemon){
        textName?.text = pokemon.name
        textUrl?.text = pokemon.url
    }
}