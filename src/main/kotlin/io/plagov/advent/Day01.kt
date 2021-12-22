package io.plagov.advent

class Day01 {

  fun partOne(input: List<String>) =
    mapToInt(input).zipWithNext { a, b -> a < b }.count { it }

  fun partTwo(input: List<String>) =
    mapToInt(input).windowed(3) { it.sum() }.zipWithNext { a, b -> a < b }.count { it }

  private fun mapToInt(input: List<String>) = input.map { it.toInt() }
}
