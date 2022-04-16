package io.plagov.advent.aoc2021

import io.plagov.advent.aoc2021.Day07
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

  @Test
  fun solveSecondForSampleInput() {
    assertEquals(168, day7.partTwo(sampleInput))
  }

  @Test
  fun solveSecondForTaskInput() {
    assertEquals(94_862_124, day7.partTwo(taskInput))
  }
}
