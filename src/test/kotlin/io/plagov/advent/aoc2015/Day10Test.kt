package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day10Test {

  private val day10 = Day10()

  private val input = "1321131112"

  @Test
  fun solveFirst() {
    assertEquals(492982, day10.partOne(input))
  }

  @Test
  fun solveSecond() {
    assertEquals(6989950, day10.partTwo(input))
  }
}
