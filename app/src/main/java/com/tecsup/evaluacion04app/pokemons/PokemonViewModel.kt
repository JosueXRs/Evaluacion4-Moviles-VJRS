package com.tecsup.evaluacion04app.pokemons

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tecsup.evaluacion04app.network.Pokemon
import com.tecsup.evaluacion04app.network.PokemonResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PokemonViewModel : ViewModel() {

    private val repository = PokemonRepository()
    private val disposable = CompositeDisposable()

    val userListResponse = MutableLiveData<List<Pokemon>>()

    fun listarPokemons() {
        disposable.add(
            repository.listarPokemons("10","0")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PokemonResponse>() {
                    override fun onSuccess(t: PokemonResponse) {

                        var listPokemons = t.results
                        userListResponse.value = listPokemons
                        Log.i("POKEMON_LIST", listPokemons.toString())

                    }

                    override fun onError(e: Throwable) {
                        Log.i("POKEMON_LIST", e.localizedMessage)
                        Log.i("POKEMON_LIST", "error")
                    }
                })
        )
    }
}