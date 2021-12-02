package io.plagov.advent

class Day01 {

  fun numbersOfIncreases(input: List<String>) =
    input.map { it.toInt() }.zipWithNext { a, b -> a < b }.count { it }
}
