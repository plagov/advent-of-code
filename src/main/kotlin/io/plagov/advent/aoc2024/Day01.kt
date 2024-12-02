package io.plagov.advent.aoc2024

import kotlin.math.abs

class Day01 {

  fun partOne(input: List<String>): Int {
    val (left, right) = parseColumnsIntoLists(input)

    return input.indices.sumOf { i -> abs(left[i] - right[i]) }
  }

  fun partTwo(input: List<String>): Int {
    val (left, right) = parseColumnsIntoLists(input)

    val map = left.map { number ->
      val occurrence = right.count { it == number }
      number to occurrence
    }

    return map.sumOf { (number, occurrence) -> number * occurrence }
  }

  private fun parseColumnsIntoLists(input: List<String>): Pair<List<Int>, List<Int>> {
    val regex = """(\d+) {3}(\d+)""".toRegex()
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()

    input.forEach { line ->
      val result = regex.find(line)!!
      val (left, right) = result.destructured
      leftList.add(left.toInt())
      rightList.add(right.toInt())
    }

    return leftList.sorted() to rightList.sorted()
  }
}
