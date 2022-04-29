package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day04Test {

  private val day4 = Day04()

  private val input = "iwrupvqb"

  @Test
  fun solveFirst() {
    assertEquals(346386, day4.partOne(input))
  }

  @Test
  fun solveSecond() {
    assertEquals(9958218, day4.partTwo(input))
  }
}
