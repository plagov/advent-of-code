package io.plagov.advent.aoc2024

import kotlin.math.pow

class Day07 {

  fun partOne(input: List<String>): Long {
    return parseInput(input)
      .filter { equation -> getBinaryCalculationResults(equation.numbers).any { it == equation.result } }
      .sumOf { it.result }
  }

  fun partTwo(input: List<String>): Long {
    return parseInput(input)
      .filter { equation ->
        getBinaryCalculationResults(equation.numbers).any { it == equation.result } ||
        getTrinaryCalculationResults(equation.numbers).any { it == equation.result }
      }
      .sumOf { it.result }
  }

  private fun parseInput(input: List<String>): List<Equation> {
    return input.map { line ->
      val result = line.substringBefore(":").toLong()
      val numbers = line.substringAfter(":").trim().split(" ").map { it.toInt() }
      Equation(result, numbers)
    }
  }

  private fun getBinaryCalculationResults(numbers: List<Int>): List<Long> {
    val numberOfOperators = getNumberOfRequiredOperators(numbers)

    return (0 until 2.0.pow(numberOfOperators).toInt())
      .map { getBinaryRepresentation(it, numberOfOperators) }
      .map { binary -> convertBinaryToOperators(binary) }
      .map { operators -> calculate(numbers, operators) }
  }

  private fun getTrinaryCalculationResults(numbers: List<Int>): List<Long> {
    val numberOfOperators = getNumberOfRequiredOperators(numbers)

    val ternaryRepresentation = (0 until 3.0.pow(numberOfOperators).toInt())
      .map { getTrinaryRepresentation(it, numberOfOperators) }
    val convertedTernaryOperators = ternaryRepresentation
      .map { ternary -> convertTrinaryToOperators(ternary) }
      .filter { combinations -> combinations.any { it.contains("|") } }
    return convertedTernaryOperators.map { operators -> calculate(numbers, operators) }
  }

  private fun calculate(numbers: List<Int>, operators: List<String>): Long {
    var result = numbers.first().toLong()

    for (op in operators.indices) {
      val nextNumber = numbers[op + 1]
      if (operators[op] == "+") {
        result += nextNumber
      } else if (operators[op] == "*") {
        result *= nextNumber
      } else if (operators[op] == "|") {
        result = "${result}${nextNumber}".toLong()
      }
    }

    return result
  }

  private fun convertBinaryToOperators(binaryString: String): List<String> {
    return binaryString.replace("0", "+").replace("1", "*").map { it.toString() }
  }

  private fun convertTrinaryToOperators(ternaryString: String): List<String> {
    return ternaryString.replace("0", "+")
      .replace("1", "*")
      .replace("2", "|")
      .map { it.toString() }
  }

  private fun getNumberOfRequiredOperators(numbers: List<Int>) = numbers.size - 1

  private fun getBinaryRepresentation(number: Int, length: Int) =
    Integer.toBinaryString(number).padStart(length, '0')

  private fun getTrinaryRepresentation(number: Int, length: Int) =
    number.toString(3).padStart(length, '0')

  data class Equation(val result: Long, val numbers: List<Int>)
}

