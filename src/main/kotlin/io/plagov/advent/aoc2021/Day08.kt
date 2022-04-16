package io.plagov.advent.aoc2021

class Day08 {

  fun partOne(input: List<String>): Int {
    val parsedOutputs = parseInputToPatternAndOutput(input).entries.map { it.value.split(" ") }

    val outputsWithUniqueDigits = parsedOutputs.flatMap { outputPart ->
      outputPart.filter { singleOutPut -> singleOutPut.length in listOf(2, 4, 3, 7) }
    }

    return outputsWithUniqueDigits.size
  }

  fun partTwo(input: List<String>): Int {
    return parseInputToPatternAndOutput(input).map { (pattern, output) ->
      parseOutputByPattern(pattern, output)
    }.sum()
  }

  private fun parseOutputByPattern(rawPattern: String, rawOutput: String): Int {
    val output = rawOutput.split(" ")
    val (a, b, c, d, e, f, g) = decodePattern(rawPattern)

    return output.joinToString("") { out ->
      when (out.toList().sorted()) {
        listOf(a, b, c, e, f, g).sorted() -> "0"
        listOf(c, f).sorted() -> "1"
        listOf(a, c, d, e, g).sorted() -> "2"
        listOf(a, c, d, f, g).sorted() -> "3"
        listOf(b, c, d, f).sorted() -> "4"
        listOf(a, b, d, f, g).sorted() -> "5"
        listOf(a, b, d, e, f, g).sorted() -> "6"
        listOf(a, c, f).sorted() -> "7"
        listOf(a, b, c, d, e, f, g).sorted() -> "8"
        listOf(a, b, c, d, f, g).sorted() -> "9"
        else -> error("Something went wrong. Output: $out")
      }
    }.toInt()
  }

  private fun decodePattern(rawPattern: String): SevenSegmentDisplay {
    val pattern = rawPattern.split(" ")

    val one = pattern.first { it.length == 2 }.toSet()
    val four = pattern.first { it.length == 4 }.toSet()
    val eight = pattern.first { it.length == 7 }.toSet()

    val a = pattern.filter { it.length in listOf(2, 3) }.flatMap { it.toList() }.groupBy { it }
      .filter { it.value.size == 1 }.entries.single().key

    val cde = pattern.filter { it.length == 6 }.flatMap { it.toList() }.groupBy { it }
      .filter { it.value.size == 2 }.entries.mapTo(HashSet()) { it.key }

    val c = cde.intersect(one).single()
    val f = one.minus(c).single()
    val d = four.minus(c).intersect(cde).single()
    val b = four.minus(setOf(c, d, f)).single()
    val e = cde.minus(setOf(c, d)).single()
    val g = eight.minus(setOf(a, b, c, d, e, f)).single()

    return SevenSegmentDisplay(a, b, c, d, e, f, g)
  }

  private fun parseInputToPatternAndOutput(input: List<String>) = input.associate {
    val (pattern, output) = it.split(""" | """)
    pattern to output
  }

  data class SevenSegmentDisplay(
    val a: Char,
    val b: Char,
    val c: Char,
    val d: Char,
    val e: Char,
    val f: Char,
    val g: Char,
  )
}
