package io.plagov.advent.aoc2015.day08

class DecodeHexNotationRule : AbstractRule<StringData>() {

  override fun apply(stringData: StringData): StringData {
    val hexRegex = """\\x[0-9aA-fF]{2}""".toRegex()
    val s = stringData.contentString
    if (s.contains(hexRegex)) {
      val hexGroups = hexRegex.findAll(s).map { it.value }.toList()
        .map {
          val h = it.drop(2).toInt(16)
          it to Char(h).toString()
        }

    }
    return stringData
  }
}
