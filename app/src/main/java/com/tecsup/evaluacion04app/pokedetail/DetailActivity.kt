package com.tecsup.evaluacion04app.pokedetail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tecsup.evaluacion04app.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
    lateinit var list: List<Types>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        viewModel.listarDetails()

        observableViewModel()
    }

    private fun observableViewModel() {
        viewModel.detailListResponse.observe(this) {
            list = it
            Log.v("lista_retrofit_details", it.toString())

            val adapter = DetailAdapter(it)
            recyclerDetail.adapter = adapter
            recyclerDetail.layoutManager = LinearLayoutManager(this)

        }
    }
}