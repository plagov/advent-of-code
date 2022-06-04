package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import util.readInputFile
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Day07Test {

  private val day7 = Day07()

  private val sampleInput = readInputFile("2015/day07-sample.txt")


  /*
  TODO this one is the same as above sample
   https://www.reddit.com/r/adventofcode/comments/rlgiyh/2015_day_7_part_one_python_the_wire_i_have_to/
x AND y -> d
x OR y -> e
x LSHIFT 2 -> f
y RSHIFT 2 -> g
NOT x -> h
NOT y -> i
123 -> x
456 -> y
   */

  private val taskInput = readInputFile("2015/day07.txt")

  @ParameterizedTest
  @MethodSource("sampleExpectedValues")
  fun solveFirstForSampleInput(key: String, value: Int) {
    assertEquals(value, day7.partOne(sampleInput, key))
  }

  @Test
  fun solveFirstForTaskInput() {
    assertEquals(3176, day7.partOne(taskInput, "a"))
  }

  private fun sampleExpectedValues() = Stream.of(
    Arguments.of("d", 72),
    Arguments.of("e", 507),
    Arguments.of("f", 492),
    Arguments.of("g", 114),
    Arguments.of("h", 65412),
    Arguments.of("i", 65079),
    Arguments.of("x", 123),
    Arguments.of("y", 456),
  )
}
