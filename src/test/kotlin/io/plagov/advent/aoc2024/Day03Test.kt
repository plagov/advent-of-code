package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.readInputFileAsString

class Day03Test {

  private val input = readInputFileAsString("2024/day03.txt")

  private val day3 = Day03()

  @Test
  fun solveFirst() {
    Assertions.assertEquals(191183308, day3.partOne(input))
  }

  @Test
  fun solveSecond() {
    Assertions.assertEquals(92082041, day3.partTwo(input))
  }
}
