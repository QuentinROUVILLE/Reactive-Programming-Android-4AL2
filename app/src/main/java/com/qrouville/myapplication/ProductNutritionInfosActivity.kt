package com.qrouville.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProductNutritionInfosActivity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.activity_product_nutritional_infos,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsFragmentNutrition: ProductNutritionFragment = requireParentFragment().requireParentFragment() as ProductNutritionFragment
        val product: Product = ProductNutritionFragmentArgs.fromBundle(detailsFragmentNutrition.requireArguments()).product

        setTableRow(view.findViewById(R.id.nutritional_tab_energy_per_100g), view.findViewById(R.id.nutritional_tab_energy_base), product.nutritionFacts.energy)
        setTableRow(view.findViewById(R.id.nutritional_tab_fat_per_100g), view.findViewById(R.id.nutritional_tab_fat_base), product.nutritionFacts.fat)
        setTableRow(view.findViewById(R.id.nutritional_tab_acid_per_100g), view.findViewById(R.id.nutritional_tab_acid_base), product.nutritionFacts.saturatedFattyAcid)
        setTableRow(view.findViewById(R.id.nutritional_tab_carbohydrates_per_100g), view.findViewById(R.id.nutritional_tab_carbohydrates_base), product.nutritionFacts.carbohydrates)
        setTableRow(view.findViewById(R.id.nutritional_tab_sugar_per_100g), view.findViewById(R.id.nutritional_tab_sugar_base), product.nutritionFacts.sugar)
        setTableRow(view.findViewById(R.id.nutritional_tab_fibre_per_100g), view.findViewById(R.id.nutritional_tab_fibre_base), product.nutritionFacts.dietaryFibre)
        setTableRow(view.findViewById(R.id.nutritional_tab_protein_per_100g), view.findViewById(R.id.nutritional_tab_protein_base), product.nutritionFacts.protein)
        setTableRow(view.findViewById(R.id.nutritional_tab_salt_per_100g), view.findViewById(R.id.nutritional_tab_salt_base), product.nutritionFacts.salt)
        setTableRow(view.findViewById(R.id.nutritional_tab_sodium_per_100g), view.findViewById(R.id.nutritional_tab_sodium_base), product.nutritionFacts.sodium)
    }

    private fun setTableRow(quantityView: TextView, portionView: TextView, nutritionFactsItem: NutritionFactsItem) {
        if (nutritionFactsItem.quantityPer100g != "") {
            quantityView.text = getString(R.string.nutritional_tab_value, nutritionFactsItem.quantityPer100g.plus(nutritionFactsItem.unit))
        }
        else {
            quantityView.text = "?"
        }

        if (nutritionFactsItem.quantityPerPortion != "") {
            portionView.text = getString(R.string.nutritional_tab_value, nutritionFactsItem.quantityPerPortion.plus(nutritionFactsItem.unit))
        }
        else {
            portionView.text = "?"
        }
    }
}