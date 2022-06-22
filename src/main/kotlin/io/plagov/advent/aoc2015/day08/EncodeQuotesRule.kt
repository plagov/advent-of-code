package io.plagov.advent.aoc2015.day08

class EncodeQuotesRule : AbstractRule<StringData>() {

  override fun apply(stringData: StringData): StringData {
    return applyNextRule(stringData.copy(lengthOfTransformedString = stringData.lengthOfOriginalString + 4))
  }
}
