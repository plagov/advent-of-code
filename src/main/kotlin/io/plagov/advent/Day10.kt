package io.plagov.advent

private val invalidPairRegex = """\{\)|\{]|\{>|\[}|\[\)|\[>|\(}|\(]|\(>|<}|<\)|<]""".toRegex()
private val matchingBracketsRegex = """\(\)|\[]|\{}|<>""".toRegex()

class Day10 {
  fun partOne(input: List<String>) = input
    .map { deleteMatchingBrackets(it) }
    .filter { it.contains(invalidPairRegex) }
    .groupingBy { invalidPairRegex.find(it)?.value?.last() ?: error("Fail to parse line: $it") }
    .eachCount()
    .entries.sumOf { (char, score) ->
      when (char) {
        ')' -> score * 3
        ']' -> score * 57
        '}' -> score * 1197
        '>' -> score * 25_137
        else -> error("Unknown character $char")
      }
    }

  private fun deleteMatchingBrackets(line: String): String {
    var s = line
    while (s.contains(matchingBracketsRegex)) {
      s = s.replace(matchingBracketsRegex, "")
    }
    return s
  }
}
