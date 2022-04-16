package io.plagov.advent.aoc2021

class Day05 {

  fun partOne(input: List<String>): Int {
    val pairsOfCoordinateLines = parseInputToLinesOfCoordinates(input)

    val linesByEqualX = linesByEqualX(pairsOfCoordinateLines)
    val linesByEqualY = linesByEqualY(pairsOfCoordinateLines)

    return (linesByEqualX + linesByEqualY).groupingBy { it }.eachCount().entries.count { it.value >= 2 }
  }

  fun partTwo(input: List<String>): Int {
    val pairsOfCoordinateLines = parseInputToLinesOfCoordinates(input)

    val verticalLines = pairsOfCoordinateLines
      .minus(pointsWithEqualX(pairsOfCoordinateLines).toSet())
      .minus(pointsWithEqualY(pairsOfCoordinateLines).toSet())
      .flatMap { point -> rangeForX(point) zip rangeForY(point) }

    val linesByEqualX = linesByEqualX(pairsOfCoordinateLines)
    val linesByEqualY = linesByEqualY(pairsOfCoordinateLines)

     return (verticalLines + linesByEqualX + linesByEqualY)
       .groupingBy { it }.eachCount().entries.count { it.value >= 2 }
  }

  private fun linesByEqualY(pairsOfCoordinateLines: List<Pair<Point, Point>>) =
    pointsWithEqualY(pairsOfCoordinateLines)
      .flatMap { point ->
        val rangeForX = rangeForX(point)
        val rangeForY = List(rangeForX.count()) { point.first.y }
        rangeForX zip rangeForY
      }

  private fun linesByEqualX(pairsOfCoordinateLines: List<Pair<Point, Point>>) =
    pointsWithEqualX(pairsOfCoordinateLines)
      .flatMap { point ->
        val rangeForY = rangeForY(point)
        val rangeForX = List(rangeForY.count()) { point.first.x }
        rangeForX zip rangeForY
      }

  private fun pointsWithEqualX(pairsOfCoordinateLines: List<Pair<Point, Point>>) =
    pairsOfCoordinateLines.filter { point -> point.first.x == point.second.x }

  private fun pointsWithEqualY(pairsOfCoordinateLines: List<Pair<Point, Point>>) =
    pairsOfCoordinateLines.filter { point -> point.first.y == point.second.y }

  private fun rangeForX(point: Pair<Point, Point>) =
    if (point.first.x < point.second.x) {
      point.first.x..point.second.x
    } else {
      point.first.x downTo point.second.x
    }

  private fun rangeForY(point: Pair<Point, Point>) =
    if (point.first.y < point.second.y) {
      (point.first.y..point.second.y)
    } else {
      (point.first.y downTo point.second.y)
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
