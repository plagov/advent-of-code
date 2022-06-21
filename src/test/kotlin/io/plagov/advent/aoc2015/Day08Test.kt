package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day08Test {

  private val day8 = Day08()

  private val taskInput = readInputFile("2015/day08.txt")

  @Test
  fun solveFirst() {
    assertEquals(1333, day8.partOne(taskInput))
  }
}
