package io.plagov.advent.aoc2015

class Day03 {
  fun partOne(input: List<String>): Int {
    var point = Point(0, 0)
    val visitedPoints = mutableSetOf<Point>()
    visitedPoints.add(point)
    input.forEach { move ->
      point = nextPoint(move, point)
      visitedPoints.add(point)
    }
    return visitedPoints.size
  }

  private fun nextPoint(move: String, currentPoint: Point): Point {
    val (x, y) = currentPoint
    return when (move) {
      ">" -> currentPoint.copy(x = x + 1)
      "<" -> currentPoint.copy(x = x - 1)
      "^" -> currentPoint.copy(y = y + 1)
      "v" -> currentPoint.copy(y = y - 1)
      else -> error("Unknown move command: $move")
    }
  }

  private data class Point(val x: Int, val y: Int)

}
