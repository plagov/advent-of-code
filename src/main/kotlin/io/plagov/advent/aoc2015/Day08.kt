package io.plagov.advent.aoc2015

import io.plagov.advent.aoc2015.day08.DecodeHexNotationRule
import io.plagov.advent.aoc2015.day08.EncodeBackslashRule
import io.plagov.advent.aoc2015.day08.EncodeDoubleQuotesRule
import io.plagov.advent.aoc2015.day08.EncodeHexNotationRule
import io.plagov.advent.aoc2015.day08.EncodeQuotesRule
import io.plagov.advent.aoc2015.day08.RemoveEscapedCharactersRule
import io.plagov.advent.aoc2015.day08.RemoveQuotesRule
import io.plagov.advent.aoc2015.day08.Rule
import io.plagov.advent.aoc2015.day08.StringData

class Day08 {

  fun partOne(input: List<String>): Int {
    val data = input.map { str ->
      StringData(
        originalString = str,
        lengthOfOriginalString = str.length
      )
    }

    val totalRawLength = data.sumOf { str -> str.lengthOfOriginalString }
    val totalContentLength = data.sumOf { str -> calculateForPartOne().apply(str).transformedString.length }
    return totalRawLength - totalContentLength
  }

  private fun calculateForPartOne(): Rule<StringData> {
    return RemoveQuotesRule()
      .setNextRule(
        RemoveEscapedCharactersRule()
          .setNextRule(DecodeHexNotationRule())
      )
  }

  fun partTwo(input: List<String>): Int {
    val data = input.map { str ->
      StringData(
        originalString = str,
        lengthOfOriginalString = str.length
      )
    }

    val totalRawLength = data.sumOf { str -> str.lengthOfOriginalString }
    val totalTransformedLength = data.sumOf { str -> calculateForPartTwo().apply(str).lengthOfTransformedString }

    return totalTransformedLength - totalRawLength
  }

  private fun calculateForPartTwo(): Rule<StringData> {
    return RemoveQuotesRule()
      .setNextRule(
        EncodeQuotesRule()
          .setNextRule(
            EncodeDoubleQuotesRule()
              .setNextRule(
                EncodeBackslashRule()
                  .setNextRule(EncodeHexNotationRule())
              )
          )
      )
  }
}
