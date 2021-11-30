package com.qrouville.myapplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_cell.view.*

class ListItemCell(v: View) : RecyclerView.ViewHolder(v) {
    val name: TextView = v.product_name
    val brand: TextView = v.product_brand
    val nutriscore: TextView = v.product_nutriscore
    val kcalories: TextView = v.product_calories
    val image: ImageView = v.product_image
}