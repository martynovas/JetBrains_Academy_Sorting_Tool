fun solution(first: List<Int>, second: List<Int>): MutableList<Int> {
    return first.toMutableList().also{ it.addAll(second)}
}