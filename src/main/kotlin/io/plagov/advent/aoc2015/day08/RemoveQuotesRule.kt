package io.plagov.advent.aoc2015.day08

class RemoveQuotesRule : AbstractRule<StringData>() {

  override fun apply(stringData: StringData): StringData {
    val stringWithoutSurroundedQuotes = stringData.rawString.drop(1).dropLast(1)
    return applyNextRule(stringData.copy(contentString = stringWithoutSurroundedQuotes))
  }
}
