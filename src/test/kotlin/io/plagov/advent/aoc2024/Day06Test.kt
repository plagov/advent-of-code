package io.plagov.advent.aoc2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import util.readInputFileAsString

class Day06Test {

    private val input = readInputFileAsString("2024/day04.txt")

    private val day6 = Day06()

    @Test
    fun partOne() {
        Assertions.assertEquals(41, day6.partOne(input))
    }
}
