package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day05Test {

  private val day5 = Day05()

  private val taskInput = readInputFile("2015/day05.txt")

  @Test
  fun solveFirst() {
    assertEquals(238, day5.partOne(taskInput))
  }

  @Test
  fun solveSecond() {
    assertEquals(69, day5.partTwo(taskInput))
  }
}
