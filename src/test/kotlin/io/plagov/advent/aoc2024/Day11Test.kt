package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day11Test {

  private val input = "337 42493 1891760 351136 2 6932 73 0"

  private val day11 = Day11()

  @Test
  fun partOne() {
    Assertions.assertEquals(233875, day11.partOne(input))
  }
}
