package com.qrouville.myapplication

fun main(){
    /*val val1 : String = "Hello it's me"
    var var2 : String = "Hello it's also me"
    var var3 : Any = "H3ll0"

    val1 = "No wait !"
    var2 = "Yes"
    var2 = 0
    var3 = 0

    ///////

    var string1 : String = "Yo"
    var string2 : String? = "Yyoo"

    string1 = null
    string2 = null

    string2 = string2.toUpperCase()
    if(string2 != null){
        string2.toUpperCase()
    }
    string2?.toUpperCase()
    string2!!.toUpperCase()

    string1 = string2 ?: "Nothing"*/

    println("Partie 1 à 5")
        println(1.isEven())
        println(isVowel('a'))
        println(isVowel('b'))

    println("Partie 6")
        println("1)")
            val user1 = User("Quentin", "ROUVILLE")
            val user2 = User("Quentin", "ROUVILLE")
            println(user1 == user2)
            println(user1)

        println("2)")
            val weather1 = Weather(20.5, "Île-de-France")
            val weather2 = Weather(weather1)

            println(weather1)
            println(weather2)

            println(weather1.isHot())
            println(weather1.isCold())

            weather1.temp = -12.0
            println(weather1.isHot())
            println(weather1.isCold())

            val domont = LocalWeather(30.0, "Domont")
            println(domont.isHot())

    println("Partie 8")
        println("2)")
            val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            var result = 0
            for (digit in list){
                result += digit
            }
            println(result)
            println(list.sum())
            println(list.sumBy { it * 2 })

            val stringList = listOf("bonjour", "le", "Monde", "je", "m'appelle", "Toto", "j'habite", "en", "Bretagne")
            println(stringList.groupBy { it.first().toUpperCase() })

        println("3)")
            val nullableList = listOf(1, 2, 3, null, 5)
            for (element in nullableList){
                if(element != null){
                    print("$element ")
                }
            }
}

fun Int.isEven (): Boolean {
    return this % 2 == 0;
}

fun isVowel (character: Char) : Boolean {
    return when(character){
        'a', 'e', 'i', 'o', 'u', 'y' -> true
        else -> false
    }
}

data class User(val firstName: String, val lastName: String) {
}

open class Weather(var temp: Double, val place: String){
    open val isColdTemp = 0
    open val isHotTemp = 25

    constructor(weather: Weather): this(weather.temp, weather.place)

    override fun toString(): String {
        return "La température de $place est de $temp°C"
    }

    fun isCold(): Boolean{
        return this.temp < isColdTemp
    }
    open fun isHot(): Boolean{
        return this.temp > isHotTemp
    }
}

class LocalWeather: Weather {
    override val isHotTemp = 32

    constructor(weather: Weather): super(weather)
    constructor(temp: Double, place: String): super(temp, place)

    override fun isHot(): Boolean {
        return this.temp > isHotTemp
    }
}