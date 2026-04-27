fun main() {
    println(birthday(age = 45, name = "Justin"))
    println("Use the val keyword when the value doesn't change.")
    println("Use the var keyword when the value can change.")
    println("When you define a function, you define the parameters that can be passed to it.")
    println("When you call a function, you pass arguments for the parameters.")
    println()
    pp_question()
}

/*
 * Kotlin arguments cannot be modified within the functions they are passed to.
 * They are passed as vals, not vars. Other than that, they behave as normal Java
 * functions do.
 */
fun birthday(name: String, age: Int): String {
    return "Happy birthday, $name! You are now $age years old."
}

fun pp_question() {
    weatherAtLocation("Gresham, OR", 5, 25, 0.1f)
    weatherAtLocation("Vancouver, BC", -1, 15, 0.35f)
}

fun weatherAtLocation(location: String, lowTemp: Int, highTemp: Int, rainChance: Float) {
    println("City: $location")
    println("Low temperature: $lowTemp C, High temperature: $highTemp C")
    println("Chance of rain: ${rainChance * 100}%\n")
}
