package io.plagov.advent.aoc2015

class Day02 {

  fun partOne(input: List<String>) = input
      .map { parseDimensions(it) }
      .sumOf { dimension -> calculateSurfaceArea(dimension) + calculateExtraPaper(dimension) }

  private data class Dimensions(val length: Int, val width: Int, val height: Int)

  private fun parseDimensions(s: String): Dimensions {
    val (length, width, height) = s.split("x").map { it.toInt() }
    return Dimensions(length, width, height)
  }

  private fun calculateSurfaceArea(dimensions: Dimensions): Int {
    val (l, w, h) = dimensions
    return (2 * l * w) + (2 * w * h) + (2 * h * l)
  }

  private fun calculateExtraPaper(dimensions: Dimensions): Int {
    val (l, w, h) = dimensions
    return minOf(l * w, w * h, h * l)
  }

}
