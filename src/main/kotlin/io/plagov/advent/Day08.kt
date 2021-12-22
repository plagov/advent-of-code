package io.plagov.advent

import io.kotest.mpp.log
import util.readInputFile

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
    val parsedPatterns = mapOfEntries.entries.map { it.key.split(" ") }

    for (pattern in parsedPatterns) {
      val one = pattern.first { it.length == 2 }
      val seven = pattern.first { it.length == 3 }
      val four = pattern.first { it.length == 4 }

      val digitA = pattern.filter { it.length in listOf(2, 3) }.map { it.toList() }.flatten().groupBy { it }.filter { it.value.size == 1 }.entries.single().key

      val (digitC, digitF) = if (one == seven.replace(digitA, Char.MIN_VALUE)) {
        one.toCharArray()
      } else {
        seven.replace(digitA, Char.MIN_VALUE).toCharArray()
      }

      // find number 4 and locate digitB and digitD. Then compare with number 0 - it doesn't have digitD

      println("")
    }

    return -1
  }

  private fun parseInputToMapOfEntries(input: List<String>) = input.associate {
    val (pattern, output) = it.split(""" | """)
    pattern to output
  }
}
