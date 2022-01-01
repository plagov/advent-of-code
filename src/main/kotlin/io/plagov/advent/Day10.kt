package io.plagov.advent

private val invalidPairRegex = """\{\)|\{]|\{>|\[}|\[\)|\[>|\(}|\(]|\(>|<}|<\)|<]""".toRegex()
private val matchingBracketsRegex = """\(\)|\[]|\{}|<>""".toRegex()

class Day10 {
  fun partOne(input: List<String>): Int {

    val invalidCharacters = mutableListOf<Char>()

    for (line in input) {
      val modifiedLine = deleteMatchingBrackets(line)

      if (modifiedLine.contains(invalidPairRegex)) {
        val invalidChar = invalidPairRegex.find(modifiedLine)?.value?.last() ?: error("Fail to parse line: $modifiedLine")
        invalidCharacters.add(invalidChar)
      }
    }

    val roundScore = invalidCharacters.count { it == ')' } * 3
    val squareScore = invalidCharacters.count { it == ']' } * 57
    val curlyScore = invalidCharacters.count { it == '}' } * 1_197
    val angleScore = invalidCharacters.count { it == '>' } * 25_137

    return roundScore + squareScore + curlyScore + angleScore
  }

  private fun deleteMatchingBrackets(line: String): String {
    var s = line
    while (s.contains(matchingBracketsRegex)) {
      s = s.replace(matchingBracketsRegex, "")
    }
    return s
  }
}
