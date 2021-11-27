package com.qrouville.myapplication

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
    val additives: List<String>?
        ){
}