package io.plagov.advent.aoc2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day01Test {

  private val sampleInputPartOne = readInputFile("2023/day01-p1-sample.txt")
  private val sampleInputPartTwo = readInputFile("2023/day01-p2-sample.txt")

  private val taskInput = readInputFile("2023/day01.txt")

  private val day1 = Day01()

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(142, day1.partOne(sampleInputPartOne))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(54338, day1.partOne(taskInput))
  }

  @Test
  fun solveSecondForSampleInput() {
    assertEquals(281, day1.partTwo(sampleInputPartTwo))
  }

  @Test
  fun solveSecondForTaskInput() {
    assertEquals(53389, day1.partTwo(taskInput))
  }
}
