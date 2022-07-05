package com.tecsup.evaluacion04app.pokemons

import com.tecsup.evaluacion04app.network.ApiService
import com.tecsup.evaluacion04app.network.PokemonResponse
import io.reactivex.Single

class PokemonRepository {

    private val api = ApiService().apiService

    fun listarPokemons(limit: String, offset: String): Single<PokemonResponse> {
        return api.listPokemon(limit, offset)
    }
}