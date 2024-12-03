package io.plagov.advent.aoc2024

import kotlin.math.abs

class Day02 {

  fun partOne(input: List<String>): Int {

    val lists = input.map { line ->
      line.split(" ")
    }

    var count = 0
    var result = 0

    lists.forEach { line ->
      line.windowed(2).forEach { pair ->
        val diff = pair.first().toInt() - pair.last().toInt()
        if (isValidDiff(diff)) {
          if (isIncrease(diff)) {
            result += 1
          } else {
            result -= 1
          }
        }
      }
      if (line.count() - 1 == abs(result)) {
        count += 1
        result = 0
      } else {
        result = 0
      }
    }

    return count
  }

  private fun isValidDiff(diff: Int): Boolean {
    return abs(diff) in 1..3
  }

  private fun isIncrease(diff: Int) = diff < 0
}
