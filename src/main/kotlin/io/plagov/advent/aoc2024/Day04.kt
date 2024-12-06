package io.plagov.advent.aoc2024

class Day04 {

  private lateinit var grid: Array<CharArray>
  private var countPartOne = 0

  fun partOne(input: String): Int {
    grid = input.lines().map { it.toCharArray() }.toTypedArray()

    for (row in grid.indices) {
      for (col in grid[row].indices) {
        val currentChar = grid[row][col]
        if (currentChar == 'X') {
          checkRight(row, col)
          checkLeft(row, col)
          checkUp(row, col)
          checkDown(row, col)
          checkDownRight(row, col)
          checkDownLeft(row, col)
          checkUpLeft(row, col)
          checkUpRight(row, col)
        }
      }
    }

    return countPartOne
  }

  fun partTwo(input: String): Int {
    grid = input.lines().map { it.toCharArray() }.toTypedArray()
    var countPartTwo = 0

    for (row in grid.indices) {
      for (col in grid[row].indices) {
        val center = grid.getElement(row, col)
        val downRight = grid.getElement(row + 1, col + 1)
        val downLeft = grid.getElement(row + 1, col - 1)
        val upLeft = grid.getElement(row - 1, col - 1)
        val upRight = grid.getElement(row - 1, col + 1)
        if (listOf(downRight, downLeft, upLeft, upRight).any { it == null }) {
          continue
        }
        if ((center == 'A' && downRight == 'S' && downLeft == 'M' && upLeft == 'M' && upRight == 'S') ||
            (center == 'A' && downRight == 'S' && downLeft == 'S' && upLeft == 'M' && upRight == 'M') ||
            (center == 'A' && downRight == 'M' && downLeft == 'M' && upLeft == 'S' && upRight == 'S') ||
            (center == 'A' && downRight == 'M' && downLeft == 'M' && upLeft == 'S' && upRight == 'S') ||
            (center == 'A' && downRight == 'M' && downLeft == 'S' && upLeft == 'S' && upRight == 'M')) {
          countPartTwo++
        }
      }
    }

    return countPartTwo
  }

  private fun checkUpRight(row: Int, col: Int) {
    val second = grid.getElement(row - 1, col + 1)
    val third = grid.getElement(row - 2, col + 2)
    val forth = grid.getElement(row - 3, col + 3)
    if (second == null || third == null || forth == null) {
      return
    }
    if (second == 'M' && third == 'A' && forth == 'S') {
      countPartOne++
    }
  }

  private fun checkUpLeft(row: Int, col: Int) {
    val second = grid.getElement(row - 1, col - 1)
    val third = grid.getElement(row - 2, col - 2)
    val forth = grid.getElement(row - 3, col - 3)
    if (second == null || third == null || forth == null) {
      return
    }
    if (second == 'M' && third == 'A' && forth == 'S') {
      countPartOne++
    }
  }

  private fun checkDownLeft(row: Int, col: Int) {
    val second = grid.getElement(row + 1, col - 1)
    val third = grid.getElement(row + 2, col - 2)
    val forth = grid.getElement(row + 3, col - 3)
    if (second == null || third == null || forth == null) {
      return
    }
    if (second == 'M' && third == 'A' && forth == 'S') {
      countPartOne++
    }
  }

  private fun checkDownRight(row: Int, col: Int) {
    val second = grid.getElement(row + 1, col + 1)
    val third = grid.getElement(row + 2, col + 2)
    val forth = grid.getElement(row + 3, col + 3)
    if (second == null || third == null || forth == null) {
      return
    }
    if (second == 'M' && third == 'A' && forth == 'S') {
      countPartOne++
    }
  }

  private fun checkDown(row: Int, col: Int) {
    val second = grid.getElement(row + 1, col)
    val third = grid.getElement(row + 2, col)
    val forth = grid.getElement(row + 3, col)
    if (second == null || third == null || forth == null) {
      return
    }
    if (second == 'M' && third == 'A' && forth == 'S') {
      countPartOne++
    }
  }

  private fun checkUp(row: Int, col: Int) {
    val second = grid.getElement(row - 1, col)
    val third = grid.getElement(row - 2, col)
    val forth = grid.getElement(row - 3, col)
    if (second == null || third == null || forth == null) {
      return
    }
    if (second == 'M' && third == 'A' && forth == 'S') {
      countPartOne++
    }
  }

  private fun checkLeft(row: Int, col: Int) {
    val second = grid.getElement(row, col - 1)
    val third = grid.getElement(row, col - 2)
    val forth = grid.getElement(row, col - 3)
    if (second == null || third == null || forth == null) {
      return
    }
    if (second == 'M' && third == 'A' && forth == 'S') {
      countPartOne++
    }
  }

  private fun checkRight(row: Int, col: Int) {
    val second = grid.getElement(row, col + 1)
    val third = grid.getElement(row, col + 2)
    val forth = grid.getElement(row, col + 3)
    if (second == null || third == null || forth == null) {
      return
    }
    if (second == 'M' && third == 'A' && forth == 'S') {
      countPartOne++
    }
  }

  private fun Array<CharArray>.getElement(row: Int, col: Int): Char? {
    return this.getOrNull(row)?.getOrNull(col)
  }
}
