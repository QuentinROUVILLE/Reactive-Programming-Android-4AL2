package com.qrouville.myapplication

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
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

        view.findViewById<TextView>(R.id.nutrition_fat_text).text = getString(R.string.nutrition_infos_fat, product.nutritionFacts.fat.quantityPer100g.plus(product.nutritionFacts.fat.unit))
        setColor(view.findViewById(R.id.nutrition_fat_sticker), view.findViewById(R.id.nutrition_fat_description), product.nutritionFacts.fat, 3.0, 20.0)

        view.findViewById<TextView>(R.id.nutrition_acid_text).text = getString(R.string.nutrition_infos_acid, product.nutritionFacts.saturatedFattyAcid.quantityPer100g.plus(product.nutritionFacts.saturatedFattyAcid.unit))
        setColor(view.findViewById(R.id.nutrition_acid_sticker), view.findViewById(R.id.nutrition_acid_description), product.nutritionFacts.saturatedFattyAcid, 1.5, 5.0)

        view.findViewById<TextView>(R.id.nutrition_sugar_text).text = getString(R.string.nutrition_infos_sugar, product.nutritionFacts.sugar.quantityPer100g.plus(product.nutritionFacts.sugar.unit))
        setColor(view.findViewById(R.id.nutrition_sugar_sticker), view.findViewById(R.id.nutrition_sugar_description), product.nutritionFacts.sugar, 5.0, 12.5)

        view.findViewById<TextView>(R.id.nutrition_salt_text).text = getString(R.string.nutrition_infos_salt, product.nutritionFacts.salt.quantityPer100g.plus(product.nutritionFacts.fat.unit))
        setColor(view.findViewById(R.id.nutrition_salt_sticker), view.findViewById(R.id.nutrition_salt_description), product.nutritionFacts.salt, 0.3, 1.5)
    }

    private fun setColor(view: View, description: TextView, nutritionFactsItem: NutritionFactsItem, lowLevelValu: Double, moderateLevelValu: Double) {
        val nutritionValue = nutritionFactsItem.quantityPer100g.replace(',', '.').toDouble()
        when {
            nutritionValue <= lowLevelValu -> {
                DrawableCompat.setTintList(view.background, ColorStateList.valueOf(resources.getColor(R.color.nutrient_level_low)))
                description.text = resources.getString(R.string.nutrition_infos_value_low)
            }
            nutritionValue <= moderateLevelValu -> {
                DrawableCompat.setTintList(view.background, ColorStateList.valueOf(resources.getColor(R.color.nutrient_level_moderate)))
                description.text = resources.getString(R.string.nutrition_infos_value_moderate)
            }
            else -> {
                DrawableCompat.setTintList(view.background, ColorStateList.valueOf(resources.getColor(R.color.nutrient_level_high)))
                description.text = resources.getString(R.string.nutrition_infos_value_high)
            }
        }
    }
}