package io.plagov.advent.aoc2015.day08

class EncodeBackslashRule : AbstractRule<StringData>() {

  override fun apply(stringData: StringData): StringData {
    val backslashRegex = """\\\\""".toRegex()
    if (stringData.originalString.contains(backslashRegex)) {
      val count = backslashRegex.findAll(stringData.originalString).count()
      return applyNextRule(stringData.copy(lengthOfTransformedString = stringData.lengthOfTransformedString + count))
    }
    return applyNextRule(stringData)
  }
}
