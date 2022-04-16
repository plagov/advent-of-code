package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day01Test {

  private val day1 = Day01()

  private val taskInput = readInputFile("2015/day01.txt")

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(232, day1.partOne(taskInput))
  }

  @Test
  fun solveSecondForTaskInput() {
    assertEquals(1783, day1.partTwo(taskInput))
  }
}
