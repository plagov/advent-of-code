package io.plagov.advent.aoc2024

import io.plagov.advent.aoc2024.Day15.Direction.*

class Day15 {

  private enum class Direction(val row: Int, val column: Int) {
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1),
    UP(-1, 0)
  }

  private var startPosition = Location(0, 0)
  private lateinit var grid: Array<CharArray>

  fun partOne(input: String): Int {
    val parsedInput = parseInput(input)

    grid = parsedInput.first
    val moves = parsedInput.second

    startPosition = findStartPosition()

    moves.forEach { move ->
      when (move) {
        '>' -> move(RIGHT)
        '<' -> move(LEFT)
        '^' -> move(UP)
        'v' -> move(DOWN)
      }
    }

    val score = calculate()

    return score
  }

  private fun calculate(): Int {
    var score = 0

    for (row in grid.indices) {
      for (col in grid[row].indices) {
        if (grid[row][col] == 'O') {
          val result = 100 * row + col
          score += result
        }
      }
    }

    return score
  }

  private fun findStartPosition(): Location {
    var rowIndex = 0
    var columnIndex = 0

    for (row in grid.indices) {
      for (col in grid[row].indices) {
        if (grid[row][col] == '@') {
          rowIndex = row
          columnIndex = col
        }
      }
    }

    return Location(rowIndex, columnIndex)
  }

  private fun move(direction: Direction) {
    val (row, col) = startPosition
    val nextPosition = grid[row + direction.row][col + direction.column]

    if (nextPosition == '#') {
      return
    }

    if (nextPosition == '.') {
      grid[row][col] = '.'
      grid[row + direction.row][col + direction.column] = '@'
      startPosition = Location(row + direction.row, col + direction.column)
      return
    }

    if (nextPosition == 'O') {
      val emptySpaceLocation = when(direction) {
        RIGHT -> findNearestEmptySpaceToRight()
        LEFT -> findNearestEmptySpaceToLeft()
        DOWN -> findNearestEmptySpaceToDown()
        UP -> findNearestEmptySpaceToUp()
      }
      if (emptySpaceLocation == null) {
        return
      } else {
        when(direction) {
          RIGHT -> moveAllToRight(emptySpaceLocation)
          LEFT -> moveAllToLeft(emptySpaceLocation)
          DOWN -> moveAllDown(emptySpaceLocation)
          UP -> moveAllUp(emptySpaceLocation)
        }
      }
    }
  }

  private fun moveAllDown(emptySpaceLocation: Location) {
    val (row, col) = startPosition

    for (i in emptySpaceLocation.row downTo row + 1) {
      grid[i][col] = grid[i - 1][col]
    }

    grid[row][col] = '.'
    startPosition = Location(row + 1, col)
  }

  private fun moveAllUp(emptySpaceLocation: Location) {
    val (row, col) = startPosition

    for (i in emptySpaceLocation.row until row) {
      grid[i][col] = grid[i + 1][col]
    }

    grid[row][col] = '.'
    startPosition = Location(row - 1, col)
  }

  private fun moveAllToLeft(emptySpaceLocation: Location) {
    val (row, col) = startPosition

    for (i in emptySpaceLocation.col until col) {
      grid[row][i] = grid[row][i + 1]
    }

    grid[row][col] = '.'
    startPosition = Location(row, col - 1)
  }

  private fun moveAllToRight(emptySpaceLocation: Location) {
    val (row, col) = startPosition

    for (i in emptySpaceLocation.col downTo col + 1) {
      grid[row][i] = grid[row][i - 1]
    }

    grid[row][col] = '.'
    startPosition = Location(row, col + 1)
  }

  private fun findNearestEmptySpaceToDown(): Location? {
    val (row, col) = startPosition

    var rowIndex: Int? = null

    for (i in row..<grid.size) {
      if (grid[i][col] == '#') {
        break
      }
      if (grid[i][col] == '.') {
        rowIndex = i
        break
      }
    }

    if (rowIndex == null) {
      return null
    }

    return Location(rowIndex, col)
  }

  private fun findNearestEmptySpaceToUp(): Location? {
    val (row, col) = startPosition

    var rowIndex: Int? = null

    for (i in row downTo 0) {
      if (grid[i][col] == '#') {
        break
      }
      if (grid[i][col] == '.') {
        rowIndex = i
        break
      }
    }

    if (rowIndex == null) {
      return null
    }

    return Location(rowIndex, col)
  }

  private fun findNearestEmptySpaceToRight(): Location? {
    val (row, col) = startPosition

    var columnIndex: Int? = null

    for (i in col..<grid[row].size) {
      if (grid[row][i] == '#') {
        break
      }
      if (grid[row][i] == '.') {
        columnIndex = i
        break
      }
    }

    if (columnIndex == null) {
      return null
    }

    return Location(row, columnIndex)
  }

  private fun findNearestEmptySpaceToLeft(): Location? {
    val (row, col) = startPosition

    var colIndex: Int? = null

    for (i in col downTo 0) {
      if (grid[row][i] == '#') {
        break
      }
      if (grid[row][i] == '.') {
        colIndex = i
        break
      }
    }

    if (colIndex == null) {
      return null
    }

    return Location(row, colIndex)
  }

  private fun parseInput(input: String): Pair<Array<CharArray>, CharArray> {
    val split = input.split("\n\n")

    val firstPart = split.first().split("\n")

    val grid = firstPart.map { line -> line.toCharArray() }.toTypedArray()
    val moves = split.last().trim().replace("\n", "").toCharArray()

    return Pair(grid, moves)
  }

  data class Location(val row: Int, val col: Int)
}
