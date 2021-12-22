package io.plagov.advent

class Day08 {

  fun partOne(input: List<String>): Int {
    val mapOfEntries = parseInputToMapOfEntries(input)

    val parsedOutputs = mapOfEntries.entries.map { it.value.split(" ") }

    val outputsWithUniqueDigits = parsedOutputs.flatMap { outputPart ->
      outputPart.filter { singleOutPut -> singleOutPut.length in listOf(2, 4, 3, 7) }
    }

    return outputsWithUniqueDigits.size
  }

  fun partTwo(input: List<String>): Int {
    val mapOfEntries = parseInputToMapOfEntries(input)

    return mapOfEntries.map { (pattern, output) ->
      parseOutputByPattern(pattern, output)
    }.sum()
  }

  private fun parseOutputByPattern(rawPattern: String, rawOutput: String): Int {
    val output = rawOutput.split(" ")
    val (a,b,c,d,e,f,g) = decodePattern(rawPattern)

    // TODO should compare ignore order
    return output.map { out ->
      when(out.toList().sorted()) {
        listOf(a, b, c, e, f, g).sorted() -> "0"
        listOf(c, f).sorted() -> "1"
        listOf(a,c,d,e,g).sorted() -> "2"
        listOf(a,c,d,f,g).sorted() -> "3"
        listOf(b,c,d,f).sorted() -> "4"
        listOf(a,b,d,f,g).sorted() -> "5"
        listOf(a,b,d,e,f,g).sorted() -> "6"
        listOf(a,c,f).sorted() -> "7"
        listOf(a,b,c,d,e,f,g).sorted() -> "8"
        listOf(a,b,c,d,f,g).sorted() -> "9"
        else -> error("Something went wrong. Output: $out")
      }
    }.joinToString("").toInt()
  }

  private fun decodePattern(rawPattern: String): SevenSegmentDisplay {
    val pattern = rawPattern.split(" ")

    val one = pattern.first { it.length == 2 }
    val four = pattern.first { it.length == 4 }
    val eight = pattern.first { it.length == 7 }

    val digitA = pattern.filter { it.length in listOf(2, 3) }.map { it.toList() }.flatten().groupBy { it }
      .filter { it.value.size == 1 }.entries.single().key

    val CandDandE = pattern.filter { it.length == 6 }.map { it.toList() }.flatten().groupBy { it }
      .filter { it.value.size == 2 }.entries.map { it.key }

    val digitC = CandDandE.intersect(one.toList()).single()
    val digitF = one.toList().minus(digitC).single()

    val digitD = four.toList().minus(digitC).intersect(CandDandE).single()
    val digitB = four.toList().minus(listOf(digitC, digitD, digitF)).single()

    val digitE = CandDandE.minus(listOf(digitC, digitD)).single()

    val digitG = eight.toList().minus(listOf(digitA, digitB, digitC, digitD, digitE, digitF).toSet()).single()

    return SevenSegmentDisplay(digitA, digitB, digitC, digitD, digitE, digitF, digitG)
  }

  private fun parseInputToMapOfEntries(input: List<String>) = input.associate {
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
