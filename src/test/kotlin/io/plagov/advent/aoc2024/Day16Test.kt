package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.readInputFile

class Day16Test {

  private val input = readInputFile("2024/day16.txt")

  private val day16 = Day16()

  @Test
  fun partOne() {
    Assertions.assertEquals(94436, day16.partOne(input))
  }
}
