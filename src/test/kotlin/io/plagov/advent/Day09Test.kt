package io.plagov.advent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.readInputFile

class Day09Test {

  private val sampleInput = readInputFile("day09-sample.txt")
  private val realInput = readInputFile("day09.txt")

  private val day9 = Day09()

  @Test
  fun solveFirstForSampleInput() {
    assertEquals(15, day9.partOne(sampleInput))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(462, day9.partOne(realInput))
  }
}
