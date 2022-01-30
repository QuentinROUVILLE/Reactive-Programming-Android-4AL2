package com.qrouville.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
class Product(
    val name: String,
    val brand: String,
    val barcode: String,
    val nutriscore: Char,
    val url: String,
    val quantity: String,
    val kiloCalories: Double,
    val countries: List<String>?,
    val ingredients: List<String>?,
    val allergenic: List<String>?,
    val additives: List<String>?,
    val nutritionFacts: @RawValue NutritionFacts
) : Parcelable
{
    companion object {
        fun createProductFromBarcode(barcode: String):Product
        {
            return Product(
                name = "Petits pois et carottes",
                brand = "Cassegrain",
                nutriscore = 'E',
                barcode = barcode,
                quantity = "400 g (280 g net égoutté)",
                countries = listOf("France", "Japon", "Suisse"),
                url = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
                ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
                kiloCalories = 234.0,
                allergenic = null,
                additives = null,
                nutritionFacts = NutritionFacts(
                    energy = NutritionFactsItem(
                        unit = "kCal",
                        quantityPerPortion = "",
                        quantityPer100g = "293"
                    ),
                    fat = NutritionFactsItem(
                        unit = "g",
                        quantityPerPortion = "",
                        quantityPer100g = "0,8"
                    ),
                    saturatedFattyAcid = NutritionFactsItem(
                        unit = "g",
                        quantityPerPortion = "",
                        quantityPer100g = "0,1"
                    ),
                    carbohydrates = NutritionFactsItem(
                        unit = "g",
                        quantityPerPortion = "",
                        quantityPer100g = "8,4"
                    ),
                    sugar = NutritionFactsItem(
                        unit = "g",
                        quantityPerPortion = "",
                        quantityPer100g = "5,2"
                    ),
                    dietaryFibre = NutritionFactsItem(
                        unit = "g",
                        quantityPerPortion = "",
                        quantityPer100g = "5,2"
                    ),
                    protein = NutritionFactsItem(
                        unit = "g",
                        quantityPerPortion = "",
                        quantityPer100g = "4,2"
                    ),
                    salt = NutritionFactsItem(
                        unit = "g",
                        quantityPerPortion = "",
                        quantityPer100g = "0,75"
                    ),
                    sodium = NutritionFactsItem(
                        unit = "g",
                        quantityPerPortion = "",
                        quantityPer100g = "0,295"
                    )
                )
            )
        }
    }
}