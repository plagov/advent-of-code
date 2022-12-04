package io.plagov.advent.aoc2022

class Day02 {

  fun partOne(input: List<String>): Int {
    return input
      .map { parseInputToCombination(it) }
      .fold(0) { score, round -> score + resolveRoundForFirstPart(round) }
  }

  fun partTwo(input: List<String>): Int {
    return input
      .map { parseInputToCombination(it) }
      .fold(0) { score, round -> score + resolveRoundForSecondPart(round) }
  }

  private fun resolveRoundForSecondPart(round: Combination): Int {
    val (opponent, you) = round
    return when {
      opponent == "A" && you == "X" -> 0 + 3
      opponent == "A" && you == "Y" -> 3 + 1
      opponent == "A" && you == "Z" -> 6 + 2
      opponent == "B" && you == "X" -> 0 + 1
      opponent == "B" && you == "Y" -> 3 + 2
      opponent == "B" && you == "Z" -> 6 + 3
      opponent == "C" && you == "X" -> 0 + 2
      opponent == "C" && you == "Y" -> 3 + 3
      opponent == "C" && you == "Z" -> 6 + 1
      else -> error("Something went wrong")
    }
  }

  private fun resolveRoundForFirstPart(round: Combination): Int {
    val (opponent, you) = round
    return when {
      opponent == "A" && you == "X" -> 1 + 3
      opponent == "A" && you == "Y" -> 2 + 6
      opponent == "A" && you == "Z" -> 3 + 0
      opponent == "B" && you == "X" -> 1 + 0
      opponent == "B" && you == "Y" -> 2 + 3
      opponent == "B" && you == "Z" -> 3 + 6
      opponent == "C" && you == "X" -> 1 + 6
      opponent == "C" && you == "Y" -> 2 + 0
      opponent == "C" && you == "Z" -> 3 + 3
      else -> error("Something went wrong")
    }
  }

  private fun parseInputToCombination(round: String): Combination {
    val opponent = round.substringBefore(" ")
    val you = round.substringAfter(" ")
    return Combination(opponent, you)
  }

  data class Combination(val opponent: String, val you: String)
}
