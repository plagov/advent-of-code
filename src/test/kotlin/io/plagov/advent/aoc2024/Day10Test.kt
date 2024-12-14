package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.readInputFileAsString

class Day10Test {

  private val input = readInputFileAsString("2024/day10.txt")

  private val day10 = Day10()

  @Test
  fun partOne() {
    Assertions.assertEquals(468, day10.partOne(input))
  }
}
