package com.qrouville.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_gradient))

        /*supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_gradient))

        findViewById<TextView>(R.id.product_name).text = products[0].name
        findViewById<TextView>(R.id.product_brand).text = products[0].brand

        findViewById<TextView>(R.id.product_nutriscore).text = "Nutriscore : ${products[0].nutriscore}"
        findViewById<TextView>(R.id.product_calories).text = "${products[0].kiloCalories} kCal/part"

        Picasso.get().load(products[0].url).into(findViewById<ImageView>(R.id.product_image))*/
    }
}