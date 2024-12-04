package io.plagov.advent.aoc2024

import kotlin.math.abs

class Day02 {

  fun partOne(input: List<String>): Int {

    val lists = input.map { line ->
      line.split(" ").map { it.toInt() }
    }

    return lists.count { line -> isLineSafe(line) }
  }

  fun partTwo(input: List<String>): Int {
    val lists = input.map { line ->
      line.split(" ").map { it.toInt() }
    }

    return lists.count { line ->
      line.indices.any { index ->
        isLineSafe(line.toMutableList().apply { removeAt(index) })
      }
    }
  }

  private fun isLineSafe(line: List<Int>): Boolean {
    val isValid = line.windowed(2).all { (a, b) -> abs(a - b) in 1..3 }
    val isIncreasing = line.windowed(2).all { (a, b) -> a < b }
    val isDecreasing = line.windowed(2).all { (a, b) -> a > b }
    return isValid && (isIncreasing || isDecreasing)
  }
}
