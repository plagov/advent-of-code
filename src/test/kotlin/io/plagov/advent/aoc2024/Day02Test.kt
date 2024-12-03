package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.readInputFile

class Day02Test {

  private val input = readInputFile("2024/day02.txt")

  private val day2 = Day02()

  @Test
  fun solveFirst() {
    Assertions.assertEquals(341, day2.partOne(input))
  }
}
