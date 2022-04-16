package io.plagov.advent.aoc2021

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day01Test {

  private val sampleInput = readInputFile("2021/day01-sample.txt")
  private val taskInput = readInputFile("2021/day01.txt")

  private val day1 = Day01()

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(7, day1.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(1316, day1.partOne(taskInput))
  }

  @Test
  fun solveSecondForSampleInput() {
    assertEquals(5, day1.partTwo(sampleInput))
  }

  @Test
  fun solveSecondTaskInput() {
    assertEquals(1344, day1.partTwo(taskInput))
  }
}
