package io.plagov.advent.aoc2015.day08

class RemoveEscapedCharactersRule : AbstractRule<StringData>() {

  override fun apply(stringData: StringData): StringData {
    val doubleQuoteRegex = """\\"""".toRegex()
    val backslashRegex = """\\\\""".toRegex()

    val replacedString = stringData.contentString
      .replace(doubleQuoteRegex, "\"")
      .replace(backslashRegex, "\\\\")

    return applyNextRule(stringData.copy(contentString = replacedString))
  }
}
