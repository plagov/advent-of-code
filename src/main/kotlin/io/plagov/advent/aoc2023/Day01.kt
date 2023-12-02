package io.plagov.advent.aoc2023

class Day01 {

  private val numbers = listOf(
    Pair("one", "o1e"),
    Pair("two", "t2o"),
    Pair("three", "t3e"),
    Pair("four", "f4r"),
    Pair("five", "f5e"),
    Pair("six", "s6x"),
    Pair("seven", "s7n"),
    Pair("eight", "e8t"),
    Pair("nine", "n9e")
  )

  fun partOne(input: List<String>) = input.sumOf { line -> solve(line) }

  fun partTwo(input: List<String>): Int {
     return input.map { line ->
      numbers.fold(line) { currentLine, (oldValue, newValue) ->
        currentLine.replace(oldValue, newValue)
      }
    }.sumOf { line -> solve(line) }
  }

  private fun solve(line: String): Int {
    val regex = Regex("""[1-9]""")
    val first = regex.findAll(line).first().value.mapToDigits()
    val last = regex.findAll(line).last().value.mapToDigits()
    return "$first$last".toInt()
  }

  private fun String.mapToDigits(): String {
    return when (this) {
      "one" -> "1"
      "two" -> "2"
      "three" -> "3"
      "four" -> "4"
      "five" -> "5"
      "six" -> "6"
      "seven" -> "7"
      "eight" -> "8"
      "nine" -> "9"
      else -> this
    }
  }
}
