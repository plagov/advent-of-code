package io.plagov.advent.aoc2015

import io.plagov.advent.aoc2015.day08.*

class Day08 {

  fun partOne(input: List<String>): Int {
    val data = input.map { str ->
      StringData(
        rawString = str,
        rawLength = str.length
      )
    }

    val totalRawLength = data.sumOf { str -> str.rawLength }
    val totalContentLength = data.sumOf { str -> calculate().apply(str).contentString.length }
    return totalRawLength - totalContentLength
  }

  private fun calculate(): Rule<StringData> {
    return RemoveQuotesRule()
      .setNextRule(RemoveEscapedCharactersRule()
        .setNextRule(DecodeHexNotationRule()))
  }
}
