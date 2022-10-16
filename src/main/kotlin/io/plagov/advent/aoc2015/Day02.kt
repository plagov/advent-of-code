package io.plagov.advent.aoc2015

class Day02 {

  fun partOne(input: List<String>) = input
    .map { parseDimensions(it) }
    .sumOf { dimension -> calculateSurfaceArea(dimension) + calculateExtraPaper(dimension) }

  fun partTwo(input: List<String>) = input
    .map { parseDimensions(it) }
    .sumOf { dimension -> ribbonToWrap(dimension) + ribbonForBow(dimension) }

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

  private fun ribbonToWrap(dimensions: Dimensions): Int {
    val (l, w, h) = dimensions
    val maxElement = maxOf(l, w, h)
    val (first, second) = listOf(l, w, h).minus(maxElement)
    return 2 * first + 2 * second
  }

  private fun ribbonForBow(dimensions: Dimensions): Int {
    val (l, w, h) = dimensions
    return l * w * h
  }
}
