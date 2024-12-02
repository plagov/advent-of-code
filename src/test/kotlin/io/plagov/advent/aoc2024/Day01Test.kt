package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.readInputFile

class Day01Test {

  private val input = readInputFile("2024/day01.txt")

  private val day1 = Day01()

  @Test
  fun solveFirst() {
    Assertions.assertEquals(1879048, day1.partOne(input))
  }

  @Test
  fun solveSecond() {
    Assertions.assertEquals(21024792, day1.partTwo(input))
  }
}
