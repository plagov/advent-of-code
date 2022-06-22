package io.plagov.advent.aoc2015.day08

class RemoveQuotesRule : AbstractRule<StringData>() {

  override fun apply(stringData: StringData): StringData {
    val stringWithoutSurroundedQuotes = stringData.originalString.drop(1).dropLast(1)
    return applyNextRule(stringData.copy(transformedString = stringWithoutSurroundedQuotes))
  }
}
