package sorting

import java.io.File
import java.util.*

fun <T : Comparable<T>> sortByCount(list: List<T>): List<Pair<T, Int>> = list
        .groupBy { it }
        .mapValues { it.value.size }
        .toList()
        .sortedWith(kotlin.Comparator { o1, o2 -> if (o1.second == o2.second) o1.first.compareTo(o2.first) else o1.second.compareTo(o2.second) })


fun processLine(lines: List<String>, sortingType: String): List<String> {
    var result = mutableListOf<String>()
    result.add("Total lines: ${lines.size}.")

    if (sortingType == "natural") {
        val sortLines = lines.sorted()
        result.add("Sorted data:")
        sortLines.forEach { result.add(it) }
    } else {
        val sortLines = sortByCount(lines)
        sortLines.forEach { result.add("${it.first}") }
    }
    return result
}

fun processWord(lines: List<String>, sortingType: String): List<String> {
    var result = mutableListOf<String>()
    val words = lines.map { it.split(" ") }.flatten().filter { it != "" }

    result.add("Total words: ${words.size}.")

    if (sortingType == "natural") {
        val sortWords = words.sorted()
        result.add("Sorted data: ${sortWords.joinToString(" ")}")
    } else {
        val sortWords = sortByCount(words)
        sortWords.forEach { result.add("${it.first}: ${it.second} time(s), ${it.second * 100 / words.size}%") }
    }
    return result
}

fun processLong(lines: List<String>, sortingType: String): List<String> {
    var result = mutableListOf<String>()
    val (good, bad) = lines
            .map { it.split(" ") }
            .flatten()
            .filter { it != "" }
            .partition { Regex("""^-?\d+""").matches(it) }
    val numbers = good.map { it.toInt() }
    bad.forEach { result.add("\"$it\" is not a long. It will be skipped.") }

    result.add("Total numbers: ${numbers.size}.")

    if (sortingType == "natural") {
        val sortNumbers = numbers.sorted()
        result.add("Sorted data: ${sortNumbers.joinToString(" ")}")
    } else {
        val sortNumbers = sortByCount(numbers)
        sortNumbers.forEach { result.add("${it.first}: ${it.second} time(s), ${it.second * 100 / numbers.size}%") }
    }
    return result
}

fun main(args: Array<String>) {
    var dataType: String = "long"
    var sortingType: String = "natural"
    var inputFileName: String? = null
    var outputFileName: String? = null
    try {
        var i = 0
        while (i < args.size) {
            when (args[i]) {
                "-dataType" ->
                    if (i == args.lastIndex || args[i + 1] !in arrayOf("word", "long", "line")) {
                        throw IllegalArgumentException("No data type defined!")
                    } else {
                        i++
                        dataType = args[i]
                    }
                "-sortingType" ->
                    if (i == args.lastIndex || args[i + 1] !in arrayOf("natural", "byCount")) {
                        throw IllegalArgumentException("No sorting type defined")
                    } else {
                        i++
                        sortingType = args[i]
                    }
                "-inputFile" ->
                    if (i == args.lastIndex) {
                        throw IllegalArgumentException("No input file defined")
                    } else {
                        i++
                        inputFileName = args[i]
                    }
                "-outputFile" ->
                    if (i == args.lastIndex) {
                        throw IllegalArgumentException("No output file defined")
                    } else {
                        i++
                        outputFileName = args[i]
                    }
                else -> println("\"${args[i]}\" is not a valid parameter. It will be skipped.")
            }
            i++
        }

        if (dataType == null)
            throw IllegalArgumentException("No data type defined!")
    } catch (e: java.lang.IllegalArgumentException) {
        println(e.message)
        return
    }

    var lines: List<String>

    if (inputFileName != null) {
        val inputFile = File(inputFileName)
        lines = inputFile.readLines()
    } else {
        val scanner = Scanner(System.`in`)
        lines = mutableListOf<String>()
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine())
        }
    }

    val result = when (dataType) {
        "long" -> processLong(lines, sortingType)
        "word" -> processWord(lines, sortingType)
        "line" -> processLine(lines, sortingType)
        else -> throw IllegalArgumentException()
    }

    if (outputFileName != null) {
        val outputFile = File(outputFileName)
        outputFile.writeText("")
        result.forEach { outputFile.appendText(it + "\n") }
    } else
        result.forEach { println(it) }
}
