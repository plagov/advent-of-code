package io.plagov.advent

class Day08 {

  fun partOne(input: List<String>): Int {
    val mapOfEntries = input.associate {
      val (pattern, output) = it.split(""" | """)
      pattern to output
    }

    val parsedOutputs = mapOfEntries.entries.map { it.value.split(" ") }

    val outputsWithUniqueDigits = parsedOutputs.flatMap { outputPart ->
      outputPart.filter { singleOutPut -> singleOutPut.length in listOf(2, 4, 3, 7) }
    }

    return outputsWithUniqueDigits.size
  }
}
