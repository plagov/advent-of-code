package io.plagov.advent.aoc2021

import io.plagov.advent.aoc2021.Day08
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

  @Test
  fun solveSecondForTaskInput() {
    assertEquals(1_074_888, day8.partTwo(taskInput))
  }
}
