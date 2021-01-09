fun main() {
    val index = readLine()!!.toInt()
    val word = readLine()!!
    if (index !in word.indices)
        println("There isn't such an element in the given string, please fix the index!")
    else
        println(word[index])
}