package com.qrouville.myapplication

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product.*


class ProductActivity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.activity_product,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val product = ProductActivityArgs.fromBundle(requireArguments()).product

        product_name.text = product.name
        product_brand.text = product.brand

        product_barcode.setTextBold(getString(R.string.product_barcode, product.barcode))
        product_quantity.setTextBold(getString(R.string.product_quantity, product.quantity))

        if(product.countries == null || product.countries.isEmpty()){
            product_countries.setTextBold(getString(R.string.product_no_countries))
        }
        else{
            product_countries.setTextBold(getString(R.string.product_countries, product.countries))
        }

        if(product.ingredients == null || product.ingredients.isEmpty()){
            product_ingredients.setTextBold(getString(R.string.product_no_ingredients))
        }
        else{
            product_ingredients.setTextBold(getString(R.string.product_ingredients, product.ingredients))
        }

        if(product.allergenic == null || product.allergenic.isEmpty()){
            product_allergenic.setTextBold(getString(R.string.product_no_allergenic))
        }
        else{
            product_allergenic.setTextBold(getString(R.string.product_allergenic, product.allergenic))
        }

        if(product.additives == null || product.additives.isEmpty()){
            product_additives.setTextBold(getString(R.string.product_no_additives))
        }
        else{
            product_additives.setTextBold(getString(R.string.product_additives, product.allergenic))
        }

        when(product.nutriscore){
            'A' -> product_nutriscore.setBackgroundResource(R.drawable.nutriscore_a)
            'B' -> product_nutriscore.setBackgroundResource(R.drawable.nutriscore_b)
            'C' -> product_nutriscore.setBackgroundResource(R.drawable.nutriscore_c)
            'D' -> product_nutriscore.setBackgroundResource(R.drawable.nutriscore_d)
            'E' -> product_nutriscore.setBackgroundResource(R.drawable.nutriscore_e)
        }
        Picasso.get().load(product.url).into(product_image)
    }

    private fun TextView.setTextBold(text: String, separator: String = ":") {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        setText(builder)
    }
}