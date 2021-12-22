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
    val mapOfEntries = parseInputToMapOfEntries(listOf("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf"))

    for (entry in mapOfEntries) {

    }

    println("")
    return -1
  }

  private fun decodePattern(rawPattern: String): SevenSegmentDisplay {
    val pattern = rawPattern.split(" ")

    val one = pattern.first { it.length == 2 }
    val seven = pattern.first { it.length == 3 }
    val four = pattern.first { it.length == 4 }
    val eight = pattern.first { it.length == 7 }
    val zeroNineOrSix = pattern.filter { it.length == 6 }

    val digitA = pattern.filter { it.length in listOf(2, 3) }.map { it.toList() }.flatten().groupBy { it }.filter { it.value.size == 1 }.entries.single().key

    val (digitC, digitF) = if (one == seven.replace(digitA.toString(), "")) {
      one.toCharArray()
    } else {
      seven.replace(digitA.toString(), "").toCharArray()
    }

    val digitBorD = four.toList().minus(seven.toList())

    val digitDorE = zeroNineOrSix.map { it.toList() }.flatten().groupBy { it }.filter { it.value.size == 2 }.entries.map { it.key }.minus(digitC)

    val digitD = digitBorD.intersect(digitDorE).single()
    val digitB = digitBorD.minus(digitD).single()
    val digitE = digitDorE.minus(digitD).single()
    val digitG = eight.toList().minus(listOf(digitA, digitB, digitC, digitD, digitE, digitF)).single()

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
