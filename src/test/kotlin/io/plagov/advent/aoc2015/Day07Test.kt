package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day07Test {

  private val day7 = Day07()

  private val taskInput = readInputFile("2015/day07.txt")

  @Test
  fun solveFirst() {
    assertEquals(3176, day7.partOne(taskInput, "a"))
  }

  @Test
  fun solveSecond() {
    assertEquals(14710, day7.partTwo(taskInput, "a"))
  }
}
