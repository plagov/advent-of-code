package io.plagov.advent.aoc2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day04Test {

  private val sampleInput = readInputFile("2023/day04-sample.txt")

  private val taskInput = readInputFile("2023/day04.txt")

  private val day04 = Day04()

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(13, day04.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(25010, day04.partOne(taskInput))
  }
}
