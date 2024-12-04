package io.plagov.advent.aoc2024

class Day03 {

  fun partOne(input: String): Int {
    val sectionRegex = """(mul\(\d{1,3},\d{1,3}\))""".toRegex()
    val numbersRegex = """(\d{1,3}),(\d{1,3})""".toRegex()
    return sectionRegex.findAll(input)
      .map { section -> section.value }
      .sumOf {
        val (a, b) = numbersRegex.find(it)?.destructured ?: error("Failed to destruct")
        a.toInt() * b.toInt()
      }
  }

  fun partTwo(input: String): Int {
    val sanitizeRegex = """don't\(\).*?do\(\)""".toRegex()
    val sanitizedInput = input
      .replace("\n", "")
      .replace(sanitizeRegex, "-")
    return partOne(sanitizedInput)
  }
}
