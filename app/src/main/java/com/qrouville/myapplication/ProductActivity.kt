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

class ProductActivity : AppCompatActivity() {
    val product = Product(
        name = "Petits pois et carottes",
        brand = "Cassegrain",
        nutriscore = 'E',
        barcode = "3083680085304",
        quantity = "400 g (280 g net égoutté)",
        countries = listOf("France", "Japon", "Suisse"),
        kiloCalories = 234.0,
        url = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
        ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
        allergenic = null,
        additives = null
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar_gradient))

        findViewById<TextView>(R.id.product_name).text = product.name
        findViewById<TextView>(R.id.product_brand).text = product.brand

        findViewById<TextView>(R.id.product_barcode).setTextBold(
            getString(R.string.product_barcode, product.barcode))
        findViewById<TextView>(R.id.product_quantity).setTextBold(
            getString(R.string.product_quantity, product.quantity))

        if(product.countries == null || product.countries.isEmpty()){
            findViewById<TextView>(R.id.product_countries).setTextBold(
                getString(R.string.product_no_countries))
        }
        else{
            findViewById<TextView>(R.id.product_countries).setTextBold(
                getString(R.string.product_countries, product.countries))
        }

        if(product.ingredients == null || product.ingredients.isEmpty()){
            findViewById<TextView>(R.id.product_ingredients).setTextBold(
                getString(R.string.product_no_ingredients))
        }
        else{
            findViewById<TextView>(R.id.product_ingredients).setTextBold(
                getString(R.string.product_ingredients, product.ingredients))
        }

        if(product.allergenic == null || product.allergenic.isEmpty()){
            findViewById<TextView>(R.id.product_allergenic).setTextBold(
                getString(R.string.product_no_allergenic))
        }
        else{
            findViewById<TextView>(R.id.product_allergenic).setTextBold(
                getString(R.string.product_allergenic, product.allergenic))
        }

        if(product.additives == null || product.additives.isEmpty()){
            findViewById<TextView>(R.id.product_additives).setTextBold(
                getString(R.string.product_no_additives))
        }
        else{
            findViewById<TextView>(R.id.product_additives).setTextBold(
                getString(R.string.product_additives, product.additives))
        }

        when(product.nutriscore){
            'A' -> findViewById<ImageView>(R.id.product_nutriscore).setBackgroundResource(R.drawable.nutriscore_a)
            'B' -> findViewById<ImageView>(R.id.product_nutriscore).setBackgroundResource(R.drawable.nutriscore_b)
            'C' -> findViewById<ImageView>(R.id.product_nutriscore).setBackgroundResource(R.drawable.nutriscore_c)
            'D' -> findViewById<ImageView>(R.id.product_nutriscore).setBackgroundResource(R.drawable.nutriscore_d)
            'E' -> findViewById<ImageView>(R.id.product_nutriscore).setBackgroundResource(R.drawable.nutriscore_e)
        }
        Picasso.get().load(product.url).into(findViewById<ImageView>(R.id.product_image))
    }

    private fun TextView.setTextBold(text: String, separator: String = ":") {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        setText(builder)
    }
}