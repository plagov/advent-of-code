package io.plagov.advent

import util.readInputFile

class Day04 {
}

fun main() {

  val input = readInputFile("day05-sample.txt")
  val regex = """^(\d+,\d+) -> (\d+,\d+)$""".toRegex()

  val pairsOfPoints = input.map { line ->
    val (coordinate1, coordinate2) = regex.find(line)?.destructured ?: error("Couldn't parse the line $line")
    val (x1, y1) = coordinate1.split(",").map { it.toInt() }
    val (x2, y2) = coordinate2.split(",").map { it.toInt() }
    Point(x1, y1) to Point(x2, y2)
  }

}

private data class Point(val x: Int, val y: Int)
