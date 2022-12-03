package io.plagov.advent.aoc2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day02Test {

  private val day2 = Day02()

  private val sampleInput = readInputFile("2022/day02-sample.txt")

  private val taskInput = readInputFile("2022/day02.txt")

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(15, day2.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(14531, day2.partOne(taskInput))
  }

  @Test
  fun solveSecondForSampleInput() {
    assertEquals(12, day2.partTwo(sampleInput))
  }

  @Test
  fun solveSecondForTaskInput() {
    assertEquals(11258, day2.partTwo(taskInput))
  }

}
