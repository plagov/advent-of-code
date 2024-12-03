package io.plagov.advent.aoc2024

import kotlin.math.abs

class Day02 {

  fun partOne(input: List<String>): Int {

    val lists = input.map { line ->
      line.split(" ")
    }

    val count = lists.count { line ->
      val result = line.windowed(2).map { pair ->
        pair.first().toInt() - pair.last().toInt()
      }.filter { diff ->
        isValidDiff(diff)
      }.fold(0) { result, diff ->
        if (isIncrease(diff)) {
          result + 1
        } else {
          result - 1
        }
      }


      line.count() - 1 == abs(result)
    }

    return count
  }

  private fun isValidDiff(diff: Int) = abs(diff) in 1..3

  private fun isIncrease(diff: Int) = diff < 0
}
