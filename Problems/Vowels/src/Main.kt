fun main() {
    val volves = mapOf("A" to 1,"E" to 5,"I" to 9,"O" to 15,"U" to 21).withDefault { 0 }
    val letter = readLine()!!
    println(volves.getValue(letter.toUpperCase()))
}