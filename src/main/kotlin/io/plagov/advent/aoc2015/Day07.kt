package io.plagov.advent.aoc2015

import io.plagov.advent.aoc2015.Day07.CommandType.*

class Day07 {

  private val notRegex = """^NOT (\w+) -> (\w+)$""".toRegex()

  private val shiftRegex = """^(\w+) ([L|R]SHIFT) (\d+) -> (\w+)$""".toRegex()

  private val andOrRegex = """^(\w+) (OR|AND) (\w+) -> (\w+)$""".toRegex()

  private val assignValueRegex = """^(\d+) -> (\w+)$""".toRegex()

  private val assignFromAnotherRegex = """^(\w+) -> (\w+)$""".toRegex()

  private data class RegexRule(
    val expression: Regex,
    val type: CommandType
  )

  enum class CommandType {
    NOT, SHIFT, AND_OR, ASSIGN_VALUE, ASSIGN_FROM_ANOTHER
  }

  private val allRegex = listOf(
    RegexRule(notRegex, NOT),
    RegexRule(shiftRegex, SHIFT),
    RegexRule(andOrRegex, AND_OR),
    RegexRule(assignValueRegex, ASSIGN_VALUE),
    RegexRule(assignFromAnotherRegex, ASSIGN_FROM_ANOTHER)
  )

//  private val score = mutableMapOf<String, Any?>()

  fun partOne(input: List<String>, searchingKey: String): Int {

    val reg = """(.*) -> (\w+)""".toRegex()

    val score: MutableMap<String, Int?> = input.associate { inp ->
      val (_, key) = reg.find(inp)?.destructured ?: error("Couldn't parse")
      key to null
    }.toMutableMap()

    println("")

    while (score[searchingKey] == null) {

      // do assignment with digits
      input.filter { it.matches(assignValueRegex) }.forEach { cmd ->
        val (value, target) = assignValueRegex.find(cmd)?.destructured ?: error("Error parsing")
        if (score[target] == null) {
          score[target] = value.toInt()
        }
      }

      // do shifting
      val knownKeysAfterAssignment = score.entries.filter { it.value != null }.map { it.key }
      val shiftReg = """^(\w+) ([L|R]SHIFT) (\d+) -> (\w+)${'$'}""".toRegex()
      input
        .filter { it.matches(shiftReg) }
        .filter { it.substringBefore(" ") in knownKeysAfterAssignment }
        .forEach { cmd ->
          val (left, operation, bitCount, target) = shiftReg.find(cmd)?.destructured ?: error("Error parsing")
          val result = getShiftResult(operation, score[left]!!, bitCount.toInt())
          if (score[target] == null) {
            score[target] = result
          }
        }

      // do NOT
      val knownKeysAfterTwoSteps = score.entries.filter { it.value != null }.map { it.key }
      val notReg = """^NOT (\w+) -> (\w+)$""".toRegex()
      input
        .filter { it.matches(notReg) }
        .filter {
          val (left, _) = notReg.find(it)?.destructured ?: error("123")
          left in knownKeysAfterTwoSteps
        }
        .forEach { cmd ->
          val (left, target) = notReg.find(cmd)?.destructured ?: error("123")
          if (score[target] == null) {
            score[target] = score[left]?.xor(65535)
          }
        }

      // do OR
      val knownKeysAfterThreeSteps = score.entries.filter { it.value != null }.map { it.key }
      val orReg = """^(\w+) OR (\w+) -> (\w+)$""".toRegex()
      input
        .filter { it.matches(orReg) }
        .filter {
          val (left, right, _) = orReg.find(it)?.destructured ?: error("213")
          knownKeysAfterThreeSteps.containsAll(listOf(left, right))
        }
        .forEach { cmd ->
          val (left, right, target) = orReg.find(cmd)?.destructured ?: error("213")
          if (score[target] == null) {
            score[target] = score[left]!! or score[right]!!
          }
        }

      // do AND
      val knownKeysAfterFourSteps = score.entries.filter { it.value != null }.map { it.key }
      val andReg = """^(\w+) AND (\w+) -> (\w+)$""".toRegex()
      input
        .filter { it.matches(andReg) }
        .filter {
          val (left, right, _) = andReg.find(it)?.destructured ?: error("213")
          knownKeysAfterFourSteps.containsAll(listOf(left, right))
        }
        .forEach { cmd ->
          val (left, right, target) = andReg.find(cmd)?.destructured ?: error("213")
          if (score[target] == null) {
            score[target] = score[left]!! and score[right]!!
          }
        }

      // do AND with one digit
      val knownKeysAfterFiveSteps = score.entries.filter { it.value != null }.map { it.key }
      val andWithDigitReg = """^(\d+) AND (\w+) -> (\w+)$""".toRegex()
      input
        .filter { it.matches(andWithDigitReg) }
        .filter {
          val (_, right, _) = andReg.find(it)?.destructured ?: error("213")
          right in knownKeysAfterFiveSteps
        }
        .forEach { cmd ->
          val (left, right, target) = andReg.find(cmd)?.destructured ?: error("213")
          if (score[target] == null) {
            score[target] = left.toInt() and score[right]!!
          }
        }

      // do assignment from another char
      val knownKeysAfterSixSteps = score.entries.filter { it.value != null }.map { it.key }
      val assignFromAnotherReg = """^(\w+) -> (\w+)$""".toRegex()
      input
        .filter { it.matches(assignFromAnotherReg) }
        .filter {
          val (source, _) = assignFromAnotherReg.find(it)?.destructured ?: error("123")
          source in knownKeysAfterSixSteps
        }
        .forEach { cmd ->
        val (source, target) = assignFromAnotherReg.find(cmd)?.destructured ?: error("Error parsing")
        if (score[target] == null) {
          score[target] = score[source]
        }
      }

     println("")
    }
    return score[searchingKey] ?: error("No value found for key '$searchingKey'")
  }

  private fun getShiftResult(
    operation: String,
    left: Int,
    bitCount: Int
  ) = when (operation) {
    "RSHIFT" -> left shr bitCount
    "LSHIFT" -> left shl bitCount
    else -> error("Unknown operation: $operation")
  }

//  private fun RegexRule.processCommand(command: String) {
//    when (type) {
//      NOT -> doNotOperation(expression, command)
//      SHIFT -> doShiftOperation(expression, command)
//      AND_OR -> doAndOrOperation(expression, command)
//      ASSIGN_VALUE -> doAssignValueOperation(expression, command)
//      ASSIGN_FROM_ANOTHER -> doAssignFromAnotherOperation(expression, command)
//    }
//  }

//  private fun doAssignFromAnotherOperation(expression: Regex, command: String) {
//    val (left, target) = expression.find(command)?.destructured ?: error("Error")
//    val lft = score[left] ?: return
//    score[target] = lft
//  }

//  private fun doAssignValueOperation(expression: Regex, command: String) {
//    val (value, target) = expression.find(command)?.destructured ?: error("Error")
//    score[target] = value.toInt()
//  }

//  private fun doAndOrOperation(expression: Regex, command: String) {
//    val (left, operation, right, target) = expression.find(command)?.destructured ?: error("Later")
//    val l = score[left]
//    val r = score[right]
//    if (l == null || r == null) {
//      return
//    } else {
//      val result = when (operation) {
//        "AND" -> l and r
//        "OR" -> l or r
//        else -> error("Unknown operation $operation")
//      }
//      score[target] = result
//    }
//  }

//  private fun doShiftOperation(expression: Regex, command: String) {
//    val (left, operation, bit, target) = expression.find(command)?.destructured ?: error("Later")
//    val lft = score[left]
//    val bitCount = bit.toInt()
//    if (lft == null) {
//      return
//    } else {
//      val result = when (operation) {
//        "LSHIFT" -> lft shl bitCount
//        "RSHIFT" -> lft shr bitCount
//        else -> error("Unknown operation $operation")
//      }
//      score[target] = result
//    }
//  }

//  private fun doNotOperation(expression: Regex, command: String) {
//    val (left, target) = expression.find(command)?.destructured
//      ?: error("Couldn't parse the command $command by the $expression regex")
//    score[target] = left.toInt().xor(65535)
//  }
}
