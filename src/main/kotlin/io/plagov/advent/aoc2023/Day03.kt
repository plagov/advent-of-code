package io.plagov.advent.aoc2023

class Day03 {

  fun partOne(input: List<String>): Int {
    val array = input.map { row -> row.chunked(1) }

    val rows = array.size - 1
    val columns = array[0].size - 1

    val numbers = mutableListOf<String>()
    var number = ""
    var shouldAdd = 0

    (0..rows).forEach { row ->
      (0..columns).forEach { column ->
        val character = array[row][column]
        if (character.matches("""\d""".toRegex())) {
          val left = array.getOrNull(row)?.getOrNull(column - 1)
          val right = array.getOrNull(row)?.getOrNull(column + 1)
          val up = array.getOrNull(row - 1)?.getOrNull(column)
          val down = array.getOrNull(row + 1)?.getOrNull(column)
          val upLeft = array.getOrNull(row - 1)?.getOrNull(column - 1)
          val upRight = array.getOrNull(row - 1)?.getOrNull(column + 1)
          val downLeft = array.getOrNull(row + 1)?.getOrNull(column - 1)
          val downRight = array.getOrNull(row + 1)?.getOrNull(column + 1)
          val adjacentPositions = listOfNotNull(left, right, up, down, upLeft, upRight, downLeft, downRight)
          if (adjacentPositions.all { it == "." || it.matches("""\d""".toRegex()) }) {
            shouldAdd += 0
          } else {
            shouldAdd += 1
          }
          number += character
        } else {
          if (shouldAdd > 0) {
            numbers.add(number)
            number = ""
            shouldAdd = 0
          } else {
            number = ""
            shouldAdd = 0
          }
        }

      }
    }

    return numbers.sumOf { it.toInt() }
  }
}
