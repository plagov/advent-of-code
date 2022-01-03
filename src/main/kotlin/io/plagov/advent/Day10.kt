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

  fun partTwo(input: List<String>): Long {
    val scores = input
      .map { deleteMatchingBrackets(it) }
      .filterNot { it.contains(invalidPairRegex) }
      .map { calculateScoreForIncompleteLine(it) }
      .sorted()
      return scores[scores.size / 2]
  }

  private fun calculateScoreForIncompleteLine(line: String) =
    line.reversed().toCharArray().fold(0L) { sum, bracket -> sum * 5 + scoreForBracket(bracket) }

  private fun scoreForBracket(bracket: Char) =
    when (bracket) {
      '(' -> 1
      '[' -> 2
      '{' -> 3
      '<' -> 4
      else -> error("Unknown bracket: $bracket")
    }
}
