package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import util.readInputFileAsString

class Day04Test {

  private val input = readInputFileAsString("2024/day04.txt")

  private val day4 = Day04()

  private val sampleInput = """
    MMMSXXMASM
    MSAMXMSMSA
    AMXSXMAAMM
    MSAMASMSMX
    XMASAMXAMM
    XXAMMXXAMA
    SMSMSASXSS
    SAXAMASAAA
    MAMMMXMMMM
    MXMXAXMASX
  """.trimIndent()

  @Test
  fun partOne() { 
    Assertions.assertEquals(2557, day4.partOne(input))
  }
}
