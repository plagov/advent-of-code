package io.plagov.advent.aoc2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFileAsString

class Day01Test {

  private val sampleInput = readInputFileAsString("2022/day01-sample.txt")

  private val taskInput = readInputFileAsString("2022/day01.txt")

  private val day1 = Day01()

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(24000, day1.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(68442, day1.partOne(taskInput))
  }

  @Test
  fun solveSecondForSampleInput() {
    assertEquals(45000, day1.partTwo(sampleInput))
  }

  @Test
  fun solveSecondForTaskInput() {
    assertEquals(204837, day1.partTwo(taskInput))
  }
}
