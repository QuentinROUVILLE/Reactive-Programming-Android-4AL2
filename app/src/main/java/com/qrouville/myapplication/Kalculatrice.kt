package com.qrouville.myapplication

import kotlin.math.round

fun main() {
    print("Saisissez votre montant HT : ")
    val result = readLine()?.toInt()

    if(result == null){
        print("Mécékwasa ?")
        return
    }

    println("TVA 2,1% : " + (result * 1.021).round(2) + "€")
    println("TVA 5,5% : " + (result * 1.055).round(2) + "€")
    println("TVA 10% : " + (result * 1.1).round(2) + "€")
    println("TVA 20% : " + (result * 1.2).round(2) + "€")
}

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}