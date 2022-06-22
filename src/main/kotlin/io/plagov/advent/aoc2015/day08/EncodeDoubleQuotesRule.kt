package io.plagov.advent.aoc2015.day08

class EncodeDoubleQuotesRule : AbstractRule<StringData>() {

  override fun apply(stringData: StringData): StringData {
    val doubleQuoteRegex = """\\"""".toRegex()
    if (stringData.originalString.contains(doubleQuoteRegex)) {
      val count = doubleQuoteRegex.findAll(stringData.originalString).count()
      return applyNextRule(stringData.copy(lengthOfTransformedString = stringData.lengthOfTransformedString + count * 2))
    }
    return applyNextRule(stringData)
  }
}
