package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day03Test {

  private val day3 = Day03()

  private val taskInput = readInputFile("2015/day03.txt")
    .joinToString { it }.toCharArray().map { it.toString() }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(2592, day3.partOne(taskInput))
  }
}
