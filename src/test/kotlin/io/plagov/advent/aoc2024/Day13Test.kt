package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.readInputFileAsString

class Day13Test {

  private val input = readInputFileAsString("2024/day13.txt")

  private val day13 = Day13()

  @Test
  fun partOne() {
    Assertions.assertEquals(28753, day13.partOne(input))
  }
}
