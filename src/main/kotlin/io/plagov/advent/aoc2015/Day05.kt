package io.plagov.advent.aoc2015

class Day05 {

  fun partOne(input: List<String>) =
    input.count { string ->
      containsThreeVowels(string) && containsConsecutiveLetters(string) && doesNotContainForbiddenLetters(string)
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

  fun partTwo(input: List<String>): Int {
    TODO("Not yet implemented")
  }

  fun containsNotOverlappingPairOfTwoLetters(word: String): Boolean {
    val windows = word.windowed(2)

    val repeatingEntries = windows
      .groupingBy { it }
      .eachCount()
      .entries
      .filter { it.value > 1 }
      .map { it.key }
      .ifEmpty { return false }

    return repeatingEntries.flatMap { en ->
      windows.withIndex().filter { it.value == en }
        .map { it.index }
    }.windowed(2)
      .none { it.last() - it.first() == 1 }
  }

  fun containsTwoRepeatingLettersWithSingleCharacterInBetween(word: String) =
    word.windowed(3).any { it.first() == it.last() }
}
