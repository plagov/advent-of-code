package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.readInputFileAsString

class Day03Test {

  private val sampleInput = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))\n"
  private val input = readInputFileAsString("2024/day03.txt")

  private val day3 = Day03()

  @Test
  fun solveFirst() {
    Assertions.assertEquals(191183308, day3.partOne(input))
  }
}
