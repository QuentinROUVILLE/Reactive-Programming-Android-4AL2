package com.qrouville.myapplication

data class NutritionFacts constructor(
    val energy: NutritionFactsItem,
    val fat: NutritionFactsItem,
    val saturatedFattyAcid: NutritionFactsItem,
    val carbohydrates: NutritionFactsItem,
    val sugar: NutritionFactsItem,
    val dietaryFibre: NutritionFactsItem,
    val protein: NutritionFactsItem,
    val salt: NutritionFactsItem,
    val sodium: NutritionFactsItem,
)