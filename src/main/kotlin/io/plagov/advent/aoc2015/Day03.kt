package io.plagov.advent.aoc2015

class Day03 {

  fun partOne(input: List<String>): Int {
    return visitedPoints(input).size
  }

  fun partTwo(input: List<String>): Int {
    val santaMoves = input.slice(0..input.lastIndex step 2)
    val robotMoves = input.slice(1..input.lastIndex step 2)

    val santaPoints = visitedPoints(santaMoves)
    val robotPoints = visitedPoints(robotMoves)

    return santaPoints.plus(robotPoints).size
  }

  private fun visitedPoints(moves: List<String>): MutableSet<Point> {
    var point = Point(0, 0)
    val visitedPoints = mutableSetOf<Point>()
    visitedPoints.add(point)
    moves.forEach { move ->
      point = nextPoint(move, point)
      visitedPoints.add(point)
    }
    return visitedPoints
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
