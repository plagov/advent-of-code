package io.plagov.advent

class Day05 {

  fun numberOfOverlappingPointsOfHorizontalAndVerticalLines(input: List<String>): Int {
    val pairsOfCoordinateLines = parseInputToLinesOfCoordinates(input)

    val linesByEqualX = pointsWithEqualX(pairsOfCoordinateLines)
      .flatMap { point ->
        val range = rangeOfYsForPointWithEqualX(point)
        range.map { y -> Point(point.first.x, y) }
      }

    val linesByEqualY = pointsWithEqualY(pairsOfCoordinateLines)
      .flatMap { point ->
        val range = rangeOfXsForPointWithEqualY(point)
        range.map { x -> Point(x, point.first.y) }
      }

    return (linesByEqualX + linesByEqualY).groupingBy { it }.eachCount().entries.count { it.value >= 2 }
  }

  private fun pointsWithEqualY(pairsOfCoordinateLines: List<Pair<Point, Point>>) =
    pairsOfCoordinateLines
      .filter { point -> point.first.y == point.second.y }

  private fun pointsWithEqualX(pairsOfCoordinateLines: List<Pair<Point, Point>>) =
    pairsOfCoordinateLines
      .filter { point -> point.first.x == point.second.x }

  fun numberOfOverlappingPointsForAllLines(input: List<String>): Int {
    val pairsOfCoordinates = parseInputToLinesOfCoordinates(input)

    val allLines = pairsOfCoordinates
      .minus(pointsWithEqualX(pairsOfCoordinates).toSet())
      .minus(pointsWithEqualY(pairsOfCoordinates).toSet())

    val verticalLines = allLines
      .flatMap { point ->

        val rangeForX = if (point.first.x < point.second.x) {
          point.first.x..point.second.x
        } else {
          point.first.x downTo point.second.x
        }

        val rangeForY = if (point.first.y < point.second.y) {
          point.first.y..point.second.y
        } else {
          point.first.y downTo point.second.y
        }

         rangeForX zip rangeForY
      }

    val linesByEqualX = pointsWithEqualX(pairsOfCoordinates)
      .flatMap { point ->
        val range = rangeOfYsForPointWithEqualX(point)
        range.map { y -> Point(point.first.x, y) }
      }

    val linesByEqualY = pointsWithEqualY(pairsOfCoordinates)
      .flatMap { point ->
        val range = rangeOfXsForPointWithEqualY(point)
        range.map { x -> Point(x, point.first.y) }
      }

    val commonList =
      verticalLines +
      linesByEqualX.map { p -> p.x to p.y } +
        linesByEqualY.map { p -> p.x to p.y }

     return commonList.groupingBy { it }.eachCount().entries.count { it.value >= 2 }
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
