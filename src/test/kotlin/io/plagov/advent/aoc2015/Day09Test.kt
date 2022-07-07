package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day09Test {

  private val sampleInput = readInputFile("2015/day09-sample.txt")
  private val taskInput = readInputFile("2015/day09.txt")

  private val day9 = Day09()

  @Test
  fun solveFirst() {
    assertEquals(605, day9.partOne(sampleInput))
//    assertEquals(-1, day9.partOne(taskInput))
  }
}

/**
 * 278 - too high
 * 172 - to high
 */
