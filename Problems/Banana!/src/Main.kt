fun solution(strings: MutableList<String>, str: String): MutableList<String> {
    val indices = strings.indices.filter { strings[it] == str }
    for (i in indices)
        strings[i] = "Banana"
    return strings
}