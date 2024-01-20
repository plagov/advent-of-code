package io.plagov.advent.aoc2023

import kotlin.math.pow

class Day04 {

  fun partOne(input: List<String>): Int {
    val cards = input.map { cardString -> parseCardString(cardString) }
    return cards.sumOf { card -> getResultForCard(card) }
  }

  fun partTwo(input: List<String>): Int {
    val cards = input.map { cardString -> parseCardString(cardString) }
    val map = cards.associateBy({ it.cardNumber }, { 1 }).toMutableMap()

    cards.forEach { card ->
      val matchingCards = getNumberOfMatchingCards(card)
      val numberOfCards = map.getValue(card.cardNumber)
      if (matchingCards > 0) {
          (card.cardNumber + 1..card.cardNumber + matchingCards).forEach {
            map[it] = map.getValue(it) + numberOfCards
        }
      }
    }

    return map.entries.sumOf { it.value }
  }

  private fun getResultForCard(card: Card): Int {
    val count = getNumberOfMatchingCards(card)
    return when (count) {
      1 -> 1
      2 -> 2
      else -> 2.toDouble().pow((count - 1)).toInt()
    }
  }

  private fun getNumberOfMatchingCards(card: Card) = card.yourNumbers.count { it in card.winningNumbers }

  private fun parseCardString(cardString: String): Card {
    val cardNumber = cardString.substringAfter("Card ").substringBefore(":").trim().toInt()

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

    return Card(cardNumber.toInt(), winningNumbers, yourNumbers)
  }
}

data class Card(
  val cardNumber: Int,
  val winningNumbers: List<Int>,
  val yourNumbers: List<Int>
)
