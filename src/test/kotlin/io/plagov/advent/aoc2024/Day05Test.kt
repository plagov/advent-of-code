package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import util.readInputFileAsString

class Day05Test {

  private val input = readInputFileAsString("2024/day05.txt")

  private val day5 = Day05()

  @Test
  fun partOne() {
    Assertions.assertEquals(5452, day5.partOne(input))
  }
}
