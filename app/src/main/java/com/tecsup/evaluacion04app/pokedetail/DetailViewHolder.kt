package com.tecsup.evaluacion04app.pokedetail

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.evaluacion04app.R
import com.tecsup.evaluacion04app.network.Pokemon

class DetailViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_detail, parent, false)){

    private var textSlot: TextView? = null
    private var textUrl: TextView? = null

    init {
        textSlot = itemView.findViewById(R.id.textSlot)
        textUrl = itemView.findViewById(R.id.textUrl)
    }

    fun bind(types: Types){
        textSlot?.text = types.slot.toString()
        textUrl?.text = types.type.toString()
    }
}