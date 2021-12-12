package io.plagov.advent

class Day05 {
  fun numberOfPointsMoreThanTwo(input: List<String>): Int {
    val pairsOfCoordinateLines = parseInputToLinesOfCoordinates(input)

    val linesByEqualX = pairsOfCoordinateLines
      .filter { point -> point.first.x == point.second.x }
      .flatMap { point ->
        val range = rangeOfYsForPointWithEqualX(point)
        range.map { y -> Point(point.first.x, y) }
      }

    val linesByEqualY = pairsOfCoordinateLines
      .filter { point -> point.first.y == point.second.y }
      .flatMap { point ->
        val range = rangeOfXsForPointWithEqualY(point)
        range.map { x -> Point(x, point.first.y) }
      }

    return (linesByEqualX + linesByEqualY).groupingBy { it }.eachCount().entries.count { it.value >= 2 }
  }

  private fun rangeOfXsForPointWithEqualY(point: Pair<Point, Point>) =
    if (point.first.x < point.second.x) {
      (point.first.x..point.second.x)
    } else {
      (point.first.x downTo point.second.x).reversed()
    }

  private fun rangeOfYsForPointWithEqualX(point: Pair<Point, Point>) =
    if (point.first.y < point.second.y) {
      (point.first.y..point.second.y)
    } else {
      (point.first.y downTo point.second.y).reversed()
    }

  private fun parseInputToLinesOfCoordinates(input: List<String>, ): List<Pair<Point, Point>> {
    val regex = """^(\d+,\d+) -> (\d+,\d+)$""".toRegex()
    return input.map { line ->
      val (coordinate1, coordinate2) = regex.find(line)?.destructured ?: error("Couldn't parse the line $line")
      val (x1, y1) = coordinate1.split(",").map { it.toInt() }
      val (x2, y2) = coordinate2.split(",").map { it.toInt() }
      Point(x1, y1) to Point(x2, y2)
    }
  }
}

private data class Point(val x: Int, val y: Int)
