package io.plagov.advent.aoc2015

class Day05 {

  fun partOne(input: List<String>) =
    input.count { string ->
      containsThreeVowels(string) && containsConsecutiveLetters(string) && doesNotContainForbiddenLetters(string)
    }

  fun partTwo(input: List<String>) =
    input.count { word ->
      containsNotOverlappingPairOfTwoLetters(word) && containsTwoRepeatingLettersWithSingleCharacterInBetween(word)
    }

  private fun containsThreeVowels(s: String): Boolean {
    val acceptedVowels = listOf("a", "e", "i", "o", "u")
    val occurrences = s.chunked(1).count { it in acceptedVowels }
    return occurrences >= 3
  }

  private fun containsConsecutiveLetters(word: String) =
    word.windowed(2).any { pair -> pair.first() == pair.last() }

  private fun doesNotContainForbiddenLetters(s: String): Boolean {
    val forbiddenLetters = listOf("ab", "cd", "pq", "xy")
    return s.windowed(2).none { it in forbiddenLetters }
  }

  private fun containsNotOverlappingPairOfTwoLetters(word: String): Boolean {
    val windows = word.windowed(2)

    val repeatingValues = windows
      .groupingBy { it }.eachCount().filter { it.value > 1 }
      .entries
      .map { it.key }
      .ifEmpty { return false }

    return repeatingValues.any { rep ->
      windows.lastIndexOf(rep) - windows.indexOf(rep) != 1
    }
  }

  private fun containsTwoRepeatingLettersWithSingleCharacterInBetween(word: String) =
    word.windowed(3).any { it.first() == it.last() }
}
