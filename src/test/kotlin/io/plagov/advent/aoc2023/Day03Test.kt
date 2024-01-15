package io.plagov.advent.aoc2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day03Test {

  private val sampleInput = readInputFile("2023/day03-sample.txt")

  private val taskInput = readInputFile("2023/day03.txt")

  private val day03 = Day03()

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(4361, day03.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(540025, day03.partOne(taskInput))
  }
}
