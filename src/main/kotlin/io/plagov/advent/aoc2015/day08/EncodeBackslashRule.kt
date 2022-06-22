package io.plagov.advent.aoc2015.day08

class EncodeBackslashRule : AbstractRule<StringData>() {

  override fun apply(stringData: StringData): StringData {
    val backslashRegex = """\\\\""".toRegex()
    if (stringData.transformedString.contains(backslashRegex)) {
      val count = backslashRegex.findAll(stringData.transformedString).count()
      return applyNextRule(stringData.copy(lengthOfTransformedString = stringData.lengthOfTransformedString + count * 2))
    }
    return applyNextRule(stringData)
  }
}
