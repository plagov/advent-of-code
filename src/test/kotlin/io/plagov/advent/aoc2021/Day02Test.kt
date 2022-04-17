package io.plagov.advent.aoc2021

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day02Test {

  private val day2 = Day02()

  private val sampleInput = readInputFile("2021/day02-sample.txt")
  private val taskInput = readInputFile("2021/day02.txt")

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(150, day2.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(1_480_518, day2.partOne(taskInput))
  }

  @Test
  fun solveSecondForSampleInput() {
    assertEquals(900, day2.partTwo(sampleInput))
  }

  @Test
  fun solveSecondForTaskInput() {
    assertEquals(1_282_809_906, day2.partTwo(taskInput))
  }
}
