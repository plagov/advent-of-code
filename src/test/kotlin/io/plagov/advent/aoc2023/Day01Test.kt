package io.plagov.advent.aoc2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day01Test {

  private val sampleInput = readInputFile("2023/day01-sample.txt")

  private val taskInput = readInputFile("2023/day01.txt")

  private val day1 = Day01()

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(142, day1.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(54338, day1.partOne(taskInput))
  }
}
