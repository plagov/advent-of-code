package io.plagov.advent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day07Test {

  private val day7 = Day07()

  private val sampleInput = readInputFile("day07-sample.txt")
  private val taskInput = readInputFile("day07.txt")

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(37, day7.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(344_138, day7.partOne(taskInput))
  }
}
