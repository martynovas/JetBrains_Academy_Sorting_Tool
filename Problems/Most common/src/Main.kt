import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val words = mutableMapOf<String,Int>()
    var word: String
    while(true) {
        word = scanner.next()
        if (word == "stop") break
        words[word] = (words[word] ?: - words.size) + 1000
    }
    val sortedWords = sortedMapOf<Int,String>()
    words.forEach{sortedWords[it.value] = it.key}
    println(sortedWords.takeIf { it.size > 0 }?.get(sortedWords.lastKey()))
}