package io.plagov.advent.aoc2015

class Day05 {

  fun partOne(input: List<String>): Int {
    TODO("Not yet implemented")
  }

  fun containsThreeVowels(s: String): Boolean {
    val acceptedVowels = listOf("a", "e", "i", "o", "u")
    val occurrences = s.chunked(1).count { it in acceptedVowels }
    return occurrences >= 3
  }

  fun containsConsecutiveLetters(s: String): Boolean {
    val windowed = s.windowed(2)
    return windowed.any { pair -> pair.first() == pair.last() }
  }

  fun doesNotContainForbiddenLetters(s: String): Boolean {
    val forbiddenLetters = listOf("ab", "cd", "pq", "xy")
    return s.windowed(2).none { it in forbiddenLetters }
  }

}
