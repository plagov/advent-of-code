package io.plagov.advent.aoc2021

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day05Test {

  private val day5 = Day05()

  private val sampleInput = readInputFile("2021/day05-sample.txt")
  private val taskInput = readInputFile("2021/day05.txt")


  @Test
  fun solveFirstForSampleInput() {
    assertEquals(5, day5.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(5576, day5.partOne(taskInput))
  }

  @Test
  fun solveSecondForSampleInput() {
    assertEquals(12, day5.partTwo(sampleInput))
  }

  @Test
  fun solveSecondForTaskInput() {
    assertEquals(18144, day5.partTwo(taskInput))
  }
}
