package com.tecsup.evaluacion04app.network

import com.tecsup.evaluacion04app.pokedetail.DetailResponse
import io.reactivex.Single
import retrofit2.http.*

interface PokemonApi {

    // https://pokeapi.co/api/v2/pokemon?limit=100&offset=0
    @GET("api/v2/pokemon")
    fun listPokemon(@Query("limit") limit: String, @Query("offset") offset: String): Single<PokemonResponse>

    // https://pokeapi.co/api/v2/pokemon/ditto
    @GET("api/v2/pokemon/{nombre}")
    fun detallePokemon(@Path("nombre") nombre: String): Single<DetailResponse>


}