package io.plagov.advent.aoc2024

class Day10 {

  private lateinit var grid: Array<IntArray>

  private val directions = listOf(
    Direction(-1, 0),
    Direction(1, 0),
    Direction(0, -1),
    Direction(0, 1)
  )

  fun partOne(input: String): Int {
    grid = input.lines().map { it.map { char -> char.digitToInt() }.toIntArray() }.toTypedArray()
    val trailheads = getLocationsOfAllTrailheads(grid)

    return trailheads.sumOf { trailhead -> getScoreForTrailhead(trailhead) }
  }

  // Breadth First Search (BFS) algorithm
  private fun getScoreForTrailhead(start: Location): Int {
    val queue: ArrayDeque<Location> = ArrayDeque()
    val visited = Array(grid.size) { BooleanArray(grid[0].size) }
    queue.addLast(start)
    visited[start.row][start.col] = true
    var score = 0

    while (queue.isNotEmpty()) {
      val current = queue.removeFirst()
      for (direction in directions) {
        val neighbourRow = current.row + direction.row
        val neighbourCol = current.col + direction.col
        val neighbour = grid.getOrNull(neighbourRow)?.getOrNull(neighbourCol)
        if (neighbour != null
          && !visited[neighbourRow][neighbourCol]
          && neighbour - grid[current.row][current.col] == 1
          && grid[current.row][current.col] != 9
        ) {
          visited[neighbourRow][neighbourCol] = true
          queue.addLast(Location(neighbourRow, neighbourCol))
          if (neighbour == 9) {
            score++
          }
        }
      }
    }
    return score
  }

  private fun getLocationsOfAllTrailheads(grid: Array<IntArray>): List<Location> {
    val locations = mutableListOf<Location>()
    for (row in grid.indices) {
      for (col in grid[row].indices) {
        if (grid[row][col] == 0) {
          locations.add(Location(row, col))
        }
      }
    }
    return locations
  }

  data class Location(val row: Int, val col: Int)
  data class Direction(val row: Int, val col: Int)
}
