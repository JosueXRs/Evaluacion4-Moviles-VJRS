package com.tecsup.evaluacion04app.pokedetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DetailAdapter (val list: List<Types>): RecyclerView.Adapter<DetailViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DetailViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val detail = list[position]
        holder.bind(detail)
    }

    override fun getItemCount(): Int = list.size
}