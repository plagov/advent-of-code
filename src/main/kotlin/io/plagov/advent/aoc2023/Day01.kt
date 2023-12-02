package io.plagov.advent.aoc2023

class Day01 {

  fun partOne(input: List<String>): Long {
    return input.sumOf { line ->
      val first = line.split("").first { it.matches("""\d""".toRegex()) }
      val last = line.split("").last { it.matches("""\d""".toRegex()) }
      "$first$last".toLong()
    }
  }
}
