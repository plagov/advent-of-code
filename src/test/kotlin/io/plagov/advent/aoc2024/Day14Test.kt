package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.readInputFile

class Day14Test {

  private val input = readInputFile("2024/day14.txt")

  private val day14 = Day14()

  @Test
  fun partOne() {
    Assertions.assertEquals(216027840, day14.partOne(input))
  }
}
