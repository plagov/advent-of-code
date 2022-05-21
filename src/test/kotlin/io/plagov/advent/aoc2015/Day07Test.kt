package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day07Test {

  private val day7 = Day07()

  private val sampleInput = readInputFile("2015/day07-sample.txt")

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(-1, day7.partOne(sampleInput))
  }
}
