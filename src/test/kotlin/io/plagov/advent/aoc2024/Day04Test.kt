package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import util.readInputFileAsString

class Day04Test {

  private val input = readInputFileAsString("2024/day04.txt")

  private val day4 = Day04()

  @Test
  fun partOne() { 
    Assertions.assertEquals(2557, day4.partOne(input))
  }

  @Test
  fun partTwo() {
    Assertions.assertEquals(1854, day4.partTwo(input))
  }
}
