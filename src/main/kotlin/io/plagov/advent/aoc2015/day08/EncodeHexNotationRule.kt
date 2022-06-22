package io.plagov.advent.aoc2015.day08

class EncodeHexNotationRule : AbstractRule<StringData>() {
  override fun apply(stringData: StringData): StringData {
    val hexRegex = """\\x[0-9aA-fF]{2}""".toRegex()
    if (stringData.transformedString.contains(hexRegex)) {
      val count = hexRegex.findAll(stringData.transformedString).count()
      return stringData.copy(lengthOfTransformedString = stringData.lengthOfTransformedString + count)
    }
    return stringData
  }
}
