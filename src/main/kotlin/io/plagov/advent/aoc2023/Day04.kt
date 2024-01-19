package io.plagov.advent.aoc2023

import kotlin.math.pow

class Day04 {

  fun partOne(input: List<String>): Int {
    val cards = input.map { cardString -> parseCardString(cardString) }
    return cards.sumOf { card -> getResultForCard(card) }
  }

  private fun getResultForCard(card: Card): Int {
    val count = card.yourNumbers.count { it in card.winningNumbers }
    return when (count) {
        1 -> 1
        2 -> 2
        else -> 2.toDouble().pow((count - 1)).toInt()
    }
  }

  private fun parseCardString(cardString: String): Card {
    val winningNumbers = cardString
      .substringAfter(": ").substringBefore(" |")
      .trim()
      .split("""\s+""".toRegex())
      .map { it.toInt() }

    val yourNumbers = cardString
      .substringAfter("| ")
      .trim()
      .split("""\s+""".toRegex())
      .map { it.toInt() }

    return Card(winningNumbers, yourNumbers)
  }
}

data class Card(
  val winningNumbers: List<Int>,
  val yourNumbers: List<Int>
)
