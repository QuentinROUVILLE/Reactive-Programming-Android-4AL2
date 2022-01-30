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
}