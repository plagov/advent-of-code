package io.plagov.advent.aoc2021

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day03Test {

  private val day3 = Day03()

  private val sampleInput = readInputFile("2021/day03-sample.txt")
  private val taskInput = readInputFile("2021/day03.txt")

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(198, day3.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(3_009_600, day3.partOne(taskInput))
  }

  @Test
  fun solveSecondForSampleInput() {
    assertEquals(230, day3.partTwo(sampleInput))
  }

  @Test
  fun solveSecondForTaskInput() {
    assertEquals(6_940_518, day3.partTwo(taskInput))
  }
}
