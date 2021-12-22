package io.plagov.advent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day08Test {

  private val day8 = Day08()

  private val sampleInput = readInputFile("day08-sample.txt")
  private val taskInput = readInputFile("day08.txt")

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(26, day8.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(548, day8.partOne(taskInput))
  }

  @Test
  fun solveSecondForSampleInput() {
    assertEquals(61229, day8.partTwo(sampleInput))
  }
}
