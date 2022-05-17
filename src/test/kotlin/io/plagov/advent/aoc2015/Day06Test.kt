package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day06Test {

  private val day6 = Day06()

  private val taskInput = readInputFile("2015/day06.txt")

  @Test
  fun solveFirst() {
    assertEquals(377891, day6.partOne(taskInput))
  }
}
