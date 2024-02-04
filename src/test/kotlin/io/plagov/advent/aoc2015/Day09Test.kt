package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day09Test {

  private val day9 = Day09()

  private val taskInput = readInputFile("2015/day09.txt")

  @Test
  fun solveFirst() {
    assertEquals(141, day9.partOne(taskInput))
  }

  @Test
  fun solveSecond() {
    assertEquals(2046, day9.partTwo(taskInput))
  }
}
