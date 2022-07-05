package com.tecsup.evaluacion04app.pokedetail

import com.tecsup.evaluacion04app.network.ApiService
import com.tecsup.evaluacion04app.network.PokemonResponse
import io.reactivex.Single

class DetailRepository {

    private val api = ApiService().apiService

    fun detallePokemon(name: String): Single<DetailResponse> {
        return api.detallePokemon(name)
    }
}