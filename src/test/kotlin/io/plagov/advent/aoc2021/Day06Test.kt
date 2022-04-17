package io.plagov.advent.aoc2021

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day06Test {

  private val day6 = Day06()

  private val sampleInput = readInputFile("2021/day06-sample.txt")
  private val taskInput = readInputFile("2021/day06.txt")

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(5934, day6.partOneAndTwo(input = sampleInput, days = 80))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(360610, day6.partOneAndTwo(input = taskInput, days = 80))
  }
}
