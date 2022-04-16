package io.plagov.advent.aoc2015

class Day01 {

  fun solve(input: List<String>): Int {
    val stringInput = input.joinToString { it }.split("")
    val up = stringInput.count { it == "(" }
    val down = stringInput.count { it == ")" }
    return up - down
  }

}
