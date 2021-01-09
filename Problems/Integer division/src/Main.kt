import java.lang.ArithmeticException
import java.lang.IllegalArgumentException

fun intDivision(x: String, y: String): Int {
    try {
        return x.toInt() / y.toInt()
    } catch (e: IllegalArgumentException) {
        println("Read values are not integers.")
        return 0
    } catch (e: ArithmeticException) {
        println("Exception: division by zero!")
        return 0
    }
}

fun main() {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))

}