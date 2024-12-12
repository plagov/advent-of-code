package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.readInputFileAsString

class Day09Test {

  private val input = readInputFileAsString("2024/day09.txt")

  private val day9 = Day09()

  @Test
  fun partOne() {
    Assertions.assertEquals(6430446922192, day9.partOne(input))
  }
}
