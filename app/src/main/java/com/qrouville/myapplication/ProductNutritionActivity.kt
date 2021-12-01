package com.qrouville.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ProductNutritionActivity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.activity_product_nutrition,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsFragmentNutrition: ProductNutritionFragment = requireParentFragment().requireParentFragment() as ProductNutritionFragment
        val product: Product = ProductNutritionFragmentArgs.fromBundle(detailsFragmentNutrition.requireArguments()).product
    }
}