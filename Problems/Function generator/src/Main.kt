fun identity(p: Int): Int = p

fun half(p: Int): Int = p / 2

fun zero(p: Int): Int = 0

fun generate(functionName: String): (Int) -> Int =
        when(functionName) {
            "identity" -> ::identity
            "half" -> ::half
            else -> ::zero
        }
