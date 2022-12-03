package io.plagov.advent.aoc2022

class Day02 {

  private var score = 0

  fun partOne(input: List<String>): Int {
    input
      .map { parseInputToCombination(it) }
      .forEach { resolveRound(it) }
    return score
  }

  /*
  A, X - rock,     1
  B, Y - paper,    2
  C, Z - scissors, 3

  win -  6
  draw - 3
  lose - 0
   */

  private fun resolveRound(round: Combination) {
    val (opponent, you) = round
    if (opponent == "A" && you == "X") {
      score += (1 + 3)
    } else if (opponent == "A" && you == "Y") {
      score += (2 + 6)
    } else if (opponent == "A" && you == "Z") {
      score += (3 + 0)
    } else if (opponent == "B" && you == "X") {
      score += (1 + 0)
    } else if (opponent == "B" && you == "Y") {
      score += (2 + 3)
    } else if (opponent == "B" && you == "Z") {
      score += (3 + 6)
    } else if (opponent == "C" && you == "X") {
      score += (1 + 6)
    } else if (opponent == "C" && you == "Y") {
      score += (2 + 0)
    } else if (opponent == "C" && you == "Z") {
      score += (3 + 3)
    }
  }

  private fun parseInputToCombination(round: String): Combination {
    val opponent = round.substringBefore(" ")
    val you = round.substringAfter(" ")
    return Combination(opponent, you)
  }

  data class Combination(val opponent: String, val you: String)
}
