package io.plagov.advent.aoc2015

class Day10 {

  fun partOne(input: String): Int {
    var result = input

    repeat(40) {
      result = getNextSequence(result)
    }

    return result.length
  }

  fun partTwo(input: String): Int {
    var result = input

    repeat(50) {
      result = getNextSequence(result)
    }

    return result.length
  }

  private fun getNextSequence(input: String): String {
    val regex = """(\d)\1*""".toRegex()

    return regex.findAll(input)
      .map { "${it.value.length}${it.value.first()}" }
      .joinToString(separator = "") { it }
  }
}
