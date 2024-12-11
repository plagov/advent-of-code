package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import util.readInputFile

class Day07Test {

  private val input = readInputFile("2024/day07.txt")

  private val day7 = Day07()

  @Test
  fun solveFirst() {
    Assertions.assertEquals(465126289353, day7.partOne(input))
  }

  @Test
  fun solveSecond() {
    Assertions.assertEquals(70597497486371, day7.partTwo(input))
  }
}
