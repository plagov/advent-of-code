package io.plagov.advent.aoc2015.day08

class EncodeHexNotationRule : AbstractRule<StringData>() {
  override fun apply(stringData: StringData): StringData {
    val hexRegex = """\\x[0-9aA-fF]{2}""".toRegex()
    if (stringData.originalString.contains(hexRegex)) {
      val count = hexRegex.findAll(stringData.originalString).count()
      return stringData.copy(lengthOfTransformedString = stringData.lengthOfTransformedString + count)
    }
    return stringData
  }
}
