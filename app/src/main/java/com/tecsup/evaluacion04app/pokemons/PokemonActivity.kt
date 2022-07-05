package com.tecsup.evaluacion04app.pokemons

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tecsup.evaluacion04app.R
import com.tecsup.evaluacion04app.network.Pokemon
import com.tecsup.evaluacion04app.pokedetail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class PokemonActivity : AppCompatActivity() {
    private lateinit var viewModel: PokemonViewModel
    lateinit var list: List<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        viewModel.listarPokemons()
        observableViewModel()

        btnDetails.setOnClickListener{
            startActivity(Intent(this, DetailActivity::class.java))
        }
    }

    private fun observableViewModel() {
        viewModel.userListResponse.observe(this) {
            list = it
            Log.v("lista_retrofit_pokemons", it.toString())

            val adapter = PokemonAdapter(it)
            recyclerPokemon.adapter = adapter
            recyclerPokemon.layoutManager = LinearLayoutManager(this)

        }
                //Semana Final:
        // PPT
        // Informe
        // Proyecto Android Studio
    }
}