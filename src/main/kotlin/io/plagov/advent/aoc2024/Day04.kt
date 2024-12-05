package io.plagov.advent.aoc2024

class Day04 {

  private lateinit var grid: Array<CharArray>
  private var count = 0

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

    return count
  }

  private fun checkUpRight(row: Int, col: Int) {
    val second = grid.getElement(row - 1, col + 1)
    val third = grid.getElement(row - 2, col + 2)
    val forth = grid.getElement(row - 3, col + 3)
    if (second == null || third == null || forth == null) {
      return
    }
    if (second == 'M' && third == 'A' && forth == 'S') {
      count++
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
      count++
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
      count++
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
      count++
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
      count++
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
      count++
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
      count++
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
      count++
    }
  }

  private fun Array<CharArray>.getElement(row: Int, col: Int): Char? {
    return this.getOrNull(row)?.getOrNull(col)
  }
}
