val lambda: (Long, Long) -> Long = { leftBorder, rightBorder ->
    var result = leftBorder
    (leftBorder + 1..rightBorder).forEach { result *= it }
    result
}