package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.readInputFileAsString

class Day15Test {

  private val input = readInputFileAsString("2024/day15.txt")

  private val day15 = Day15()

  @Test
  fun partOne() {
    Assertions.assertEquals(1415498, day15.partOne(input))
  }
}
