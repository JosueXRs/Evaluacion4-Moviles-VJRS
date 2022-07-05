package com.tecsup.evaluacion04app.pokedetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class DetailViewModel : ViewModel() {

    private val repository = DetailRepository()
    private val disposable = CompositeDisposable()

    val detailListResponse = MutableLiveData<List<Types>>()

    fun listarDetails() {
        disposable.add(
            repository.detallePokemon("bulbasaur")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<DetailResponse>() {
                    override fun onSuccess(t: DetailResponse) {

                        var listDetails = t.types
                        detailListResponse.value = listDetails
                        Log.i("POKEMON_DETAIL", listDetails.toString())

                    }

                    override fun onError(e: Throwable) {
                        Log.i("POKEMON_DETAIL", e.localizedMessage)
                        Log.i("POKEMON_DETAIL", "error")
                    }
                })
        )
    }
}