package com.qrouville.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val products: List<Product>, private val listener: OnItemClickedListener) : RecyclerView.Adapter<ListItemCell>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemCell {
        return ListItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(cell: ListItemCell, position: Int) {
        cell.name.text = products[position].name
        cell.brand.text = products[position].brand
        cell.nutriscore.text = "Nutriscore : ${products[position].nutriscore}"
        cell.kcalories.text = "${products[position].kiloCalories} kCal/part"

        /*cell.text.setOnClickListener {
            listener.onItemClicked(products[position])
        }*/
    }

    override fun getItemCount(): Int {
        return products.size
    }

}