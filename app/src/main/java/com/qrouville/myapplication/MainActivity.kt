package com.qrouville.myapplication

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    val product = Product(
        name = "Petits pois et carottes",
        brand = "Cassegrain",
        nutriscore = 'E',
        barcode = "3083680085304",
        quantity = "400 g (280 g net égoutté)",
        countries = listOf("France", "Japon", "Suisse"),
        url = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
        ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
        kiloCalories = 234.0,
        allergenic = null,
        additives = null
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_item_cell)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_gradient))

        findViewById<TextView>(R.id.product_name).text = product.name
        findViewById<TextView>(R.id.product_brand).text = product.brand

        findViewById<TextView>(R.id.product_nutriscore).text = "Nutriscore : ${product.nutriscore}"
        findViewById<TextView>(R.id.product_calories).text = "${product.kiloCalories} kCal/part"

        Picasso.get().load(product.url).into(findViewById<ImageView>(R.id.product_image))
    }

    private fun TextView.setTextBold(text: String, separator: String = ":") {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        setText(builder)
    }
}