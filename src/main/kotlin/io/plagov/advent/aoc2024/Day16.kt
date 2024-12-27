package io.plagov.advent.aoc2024

import io.plagov.advent.aoc2024.Day16.Direction.*
import java.util.PriorityQueue
import kotlin.math.abs

class Day16 {

  fun partOne(input: List<String>): Int? {
    val maze = input.map { it.toCharArray() }.toTypedArray()

    val result = calculateLowestScoreForPath(maze)

    return result
  }

  // A* (A-star) algorithm
  private fun calculateLowestScoreForPath(maze: Array<CharArray>): Int? {
    val start = findPositionFor(maze, 'S')
    val end = findPositionFor(maze, 'E')

    val queue = PriorityQueue<State>()
    queue.add(State(0, 0, start, EAST))

    val visited = mutableSetOf<Pair<Point, Direction>>()

    while (queue.isNotEmpty()) {
      val (_, currentCost, currentPosition, currentDirection) = queue.poll()

      if (currentPosition == end) {
        return currentCost
      }

      if (visited.contains(Pair(currentPosition, currentDirection))) {
        continue
      }
      visited.add(Pair(currentPosition, currentDirection))

      val newPoint = moveForward(currentPosition, currentDirection, maze)
      if (newPoint != null) {
        val newCost = currentCost + 1
        val heuristic = getManhattanDistance(newPoint, end)
        queue.add(State(newCost + heuristic, newCost, newPoint, currentDirection))
      }

      val newClockWiseDirection = currentDirection.rotateClockwise()
      val newClockWiseCost = currentCost + 1000
      val newClockWiseHeuristic = getManhattanDistance(currentPosition, end)
      queue.add(State(newClockWiseCost + newClockWiseHeuristic, newClockWiseCost, currentPosition, newClockWiseDirection))

      val newCounterClockWiseDirection = currentDirection.rotateCounterClockwise()
      val newCounterClockWiseCost = currentCost + 1000
      val newCounterClockWiseHeuristic = getManhattanDistance(currentPosition, end)
      queue.add(State(newCounterClockWiseCost + newCounterClockWiseHeuristic, newCounterClockWiseCost, currentPosition, newCounterClockWiseDirection))
    }

    return null
  }

  private fun findPositionFor(maze: Array<CharArray>, char: Char): Point {
    var rowIndex = 0
    var colIndex = 0

    for (row in maze.indices) {
      for (col in maze[row].indices) {
        if (maze[row][col] == char) {
          rowIndex = row
          colIndex = col
        }
      }
    }

    return Point(rowIndex, colIndex)
  }

  private fun moveForward(point: Point, direction: Direction, maze: Array<CharArray>): Point? {
    val newRow = point.row + direction.rowOffset
    val newCol = point.col + direction.colOffset

    return if (isWithinBounds(Point(newRow, newCol), maze) && maze[newRow][newCol] != '#') {
      Point(newRow, newCol)
    } else {
      null
    }
  }

  private fun isWithinBounds(point: Point, maze: Array<CharArray>): Boolean {
    return (0 <= point.row && point.row < maze.size)
      && (0 <= point.col && point.col < maze[0].size)
  }

  private fun getManhattanDistance(currentPoint: Point, goal: Point): Int {
    return abs(goal.row - currentPoint.row) + abs(goal.col - currentPoint.col)
  }

  data class State(
    val priority: Int,
    val cost: Int,
    val position: Point,
    val direction: Direction
  ) : Comparable<State> {
    override fun compareTo(other: State) = priority.compareTo(other.priority)
  }

  data class Point(val row: Int, val col: Int)

  enum class Direction(val rowOffset: Int, val colOffset: Int) {
    NORTH(-1, 0),
    EAST(0, 1),
    SOUTH(1, 0),
    WEST(0, -1);

    fun rotateClockwise(): Direction = when (this) {
      NORTH -> EAST
      EAST -> SOUTH
      SOUTH -> WEST
      WEST -> NORTH
    }

    fun rotateCounterClockwise(): Direction = when (this) {
      NORTH -> WEST
      WEST -> SOUTH
      SOUTH -> EAST
      EAST -> NORTH
    }
  }
}
