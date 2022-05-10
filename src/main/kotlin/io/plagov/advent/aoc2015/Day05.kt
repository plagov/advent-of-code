package io.plagov.advent.aoc2015

class Day05 {

  fun partOne(input: List<String>): Int {
    TODO("Not yet implemented")
  }

  fun containsThreeVowels(s: String): Boolean {
    val acceptedVowels = listOf("a", "e", "i", "o", "u")
    val occurrences = s.split("").count { it -> it in acceptedVowels }
    return occurrences >= 3
  }

}
