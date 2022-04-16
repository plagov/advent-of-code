package io.plagov.advent.aoc2015

class Day01 {

  fun partOne(input: List<String>): Int {
    val up = input.count { it == "(" }
    val down = input.count { it == ")" }
    return up - down
  }

  fun partTwo(input: List<String>): Int {
    val ints = input
      .map { it
        .replace("""\(""".toRegex(), "1")
        .replace("""\)""".toRegex(), "-1")
      }
      .map { it.toInt() }
    var position = 1
    var score = ints.first()
    while (true) {
      score += ints[position]
      if (score < 0) {
        break
      }
      position++
    }
    return position + 1
  }

}
