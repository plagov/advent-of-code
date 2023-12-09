package io.plagov.advent.aoc2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day02Test {

  private val sampleInput = readInputFile("2023/day02-sample.txt")

  private val taskInput = readInputFile("2023/day02.txt")

  private val day02 = Day02()

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(8, day02.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(2416, day02.partOne(taskInput))
  }

  @Test
  fun solveSecondForSampleInput() {
    assertEquals(2286, day02.partTwo(sampleInput))
  }

  @Test
  fun solveSecondForTaskInput() {
    assertEquals(63307, day02.partTwo(taskInput))
  }
}
