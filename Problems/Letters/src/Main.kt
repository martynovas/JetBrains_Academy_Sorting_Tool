import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val letters = mutableMapOf<Int,Char>()
    do{
        letters[letters.size + 1] = scanner.nextLine()[0]
    } while (letters[letters.size] != 'z')

    print(letters[4].takeIf { it != 'z' })
}