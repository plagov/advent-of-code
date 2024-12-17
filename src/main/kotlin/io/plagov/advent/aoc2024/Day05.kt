package io.plagov.advent.aoc2024

class Day05 {

  fun partOne(input: String): Int {
    val (rules, updates) = parseInput(input)

    return updates
      .filter { update -> isValidUpdate(update, rules) }
      .sumOf { getMiddleElement(it) }
  }

  private fun getMiddleElement(update: List<String>): Int {
    return update[update.size / 2].toInt()
  }

  private fun isValidUpdate(update: List<String>, rules: List<String>): Boolean {
    var isValid = true

    for (i in 0 until update.size - 1) {
      for (j in i + 1 until update.size) {
        if (!rules.contains("${update[i]}|${update[j]}")) {
          isValid = false
        }
      }
    }

    return isValid
  }

  private fun parseInput(input: String): Pair<List<String>, List<List<String>>> {
    val split = input.split("\n\n")

    val rules = split.first().split("\n")
    val updates = split.last().trim().split("\n").map { it.split(",") }
    return Pair(rules, updates)
  }
}
