package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day02Test {

  private val day2 = Day02()

  private val taskInput = readInputFile("2015/day02.txt")

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(1_588_178, day2.partOne(taskInput))
  }
}
