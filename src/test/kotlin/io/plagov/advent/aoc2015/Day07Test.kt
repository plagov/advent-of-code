package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import util.readInputFile
import java.util.stream.Stream

class Day07Test {

  private val day7 = Day07()

  private val taskInput = readInputFile("2015/day07.txt")

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(3176, day7.partOne(taskInput, "a"))
  }
}
