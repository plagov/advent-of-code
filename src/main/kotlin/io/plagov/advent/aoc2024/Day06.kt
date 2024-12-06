package io.plagov.advent.aoc2024

class Day06 {

  private var countPartOne = 0
  private lateinit var grid: Array<CharArray>
  private var isInside = true
  private var direction = "up"
  private lateinit var startPosition: Pair<Int, Int>

  fun partOne(input: String): Int {
    grid = input.lines().map { it.toCharArray() }.toTypedArray()
    startPosition = findStartingPosition(grid)
    while (direction.isNotEmpty()) {
      when (direction) {
        "up" -> moveUp(startPosition)
        "right" -> moveRight(startPosition)
      }
    }
    return -1
  }

  private fun moveRight(position: Pair<Int, Int>) {
    val (startRow, startCol) = position
    for (col in startCol downTo grid.size) {
      if (grid[startRow][col] == '#') {
        direction = "down"
        startPosition = Pair(startRow, col)
        return
      }
      countPartOne++
    }
  }

  private fun moveUp(position: Pair<Int, Int>) {
    val (startRow, startCol) = position
    for (row in startRow downTo 0) {
      if (grid[row][startCol] == '#') {
        direction = "right"
        startPosition = Pair(row, startCol)
        return
      }
      countPartOne++
    }
  }

  private fun findStartingPosition(grid: Array<CharArray>): Pair<Int, Int> {
    val row = grid.indexOfFirst { row -> row.contains('^') }
    val col = grid[row].indexOfFirst { col -> col == '^' }
    return Pair(row, col)
  }
}
