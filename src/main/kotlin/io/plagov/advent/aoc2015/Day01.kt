package io.plagov.advent.aoc2015

class Day01 {

  fun partOne(input: List<String>): Int {
    val stringInput = input.joinToString { it }.split("")
    val up = stringInput.count { it == "(" }
    val down = stringInput.count { it == ")" }
    return up - down
  }

  fun partTwo(input: List<String>): Int {
    val stringInput = input
      .joinToString { it }
      .toCharArray().map { it.toString() }
      .map { it.replace("""\(""".toRegex(), "1").replace("""\)""".toRegex(), "-1") }
      .map { it.toInt() }
    var position = 1
    var score = stringInput.first()
    while (true) {
      score += stringInput[position]
      if (score < 0) {
        break
      }
      position++
    }
    return position + 1
  }

}
