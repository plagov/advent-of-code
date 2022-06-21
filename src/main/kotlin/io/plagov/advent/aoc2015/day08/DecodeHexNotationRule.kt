package io.plagov.advent.aoc2015.day08

class DecodeHexNotationRule : AbstractRule<StringData>() {

  override fun apply(stringData: StringData): StringData {
    val hexRegex = """\\x[0-9aA-fF]{2}""".toRegex()
    var s = stringData.contentString
    if (s.contains(hexRegex)) {
      hexRegex.findAll(s).map { it.value }.toList()
        .map {
          val h = it.drop(2).toInt(16)
          it to Char(h).toString()
        }.forEach { hexGroup ->
          s = s.replace(hexGroup.first, hexGroup.second)
        }
      return stringData.copy(contentString = s)
    }
    return stringData
  }
}
