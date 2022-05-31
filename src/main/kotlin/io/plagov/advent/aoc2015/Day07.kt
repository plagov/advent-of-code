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

  private val score = mutableMapOf<String, Int>()

  fun partOne(input: List<String>, searchingKey: String): Int {

    // do assignments first
    input.filter { it.matches(assignValueRegex) }.forEach { cmd ->
      val (value, target) = assignValueRegex.find(cmd)?.destructured ?: error("Error parsing")
      score[target] = value.toInt()
    }

    // do shifting
    val shiftMap = score.toMutableMap()
    score.forEach { (key, value) ->
      val reg = """^${key} ([L|R]SHIFT) (\d+) -> (\w+)${'$'}""".toRegex()
      input
        .filter { it.matches(reg) }
        .forEach { cmd ->
          val (operation, bitCount, target) = reg.find(cmd)?.destructured ?: error("Error parsing")
          val result = getShiftResult(operation, value, bitCount.toInt())
          shiftMap[target] = result
        }
    }
    score.putAll(shiftMap)

    // do NOT operation
    val notMap = score.toMutableMap()
    score.forEach { (key, value) ->
      val reg = """^NOT $key -> (\w+)$""".toRegex()
      input
        .filter { it.matches(reg) }
        .forEach { cmd ->
          val (target) = reg.find(cmd)?.destructured ?: error("Error parsing")
          notMap[target] = value.xor(65535)
        }
    }
    score.putAll(notMap)

    // operations with two
    val twoKeysMap = score.toMutableMap()
    score.forEach { (key1, value1) ->
      score.forEach { (key2, value2) ->
        val reg = """^$key1 (OR|AND|RSHIFT|LSHIFT) $key2 -> (\w+)$""".toRegex()
      }
    }

    println("")

    input.forEach { cmd ->
      val regexRule = allRegex.find { rule -> rule.expression.matches(cmd) }
        ?: error("Command '$cmd' doesn't match any regex")

      regexRule.processCommand(cmd)
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

  private fun RegexRule.processCommand(command: String) {
    when (type) {
      NOT -> doNotOperation(expression, command)
      SHIFT -> doShiftOperation(expression, command)
      AND_OR -> doAndOrOperation(expression, command)
      ASSIGN_VALUE -> doAssignValueOperation(expression, command)
      ASSIGN_FROM_ANOTHER -> doAssignFromAnotherOperation(expression, command)
    }
  }

  private fun doAssignFromAnotherOperation(expression: Regex, command: String) {
    val (left, target) = expression.find(command)?.destructured ?: error("Error")
    val lft = score[left] ?: return
    score[target] = lft
  }

  private fun doAssignValueOperation(expression: Regex, command: String) {
    val (value, target) = expression.find(command)?.destructured ?: error("Error")
    score[target] = value.toInt()
  }

  private fun doAndOrOperation(expression: Regex, command: String) {
    val (left, operation, right, target) = expression.find(command)?.destructured ?: error("Later")
    val l = score[left]
    val r = score[right]
    if (l == null || r == null) {
      return
    } else {
      val result = when (operation) {
        "AND" -> l and r
        "OR" -> l or r
        else -> error("Unknown operation $operation")
      }
      score[target] = result
    }
  }

  private fun doShiftOperation(expression: Regex, command: String) {
    val (left, operation, bit, target) = expression.find(command)?.destructured ?: error("Later")
    val lft = score[left]
    val bitCount = bit.toInt()
    if (lft == null) {
      return
    } else {
      val result = when (operation) {
        "LSHIFT" -> lft shl bitCount
        "RSHIFT" -> lft shr bitCount
        else -> error("Unknown operation $operation")
      }
      score[target] = result
    }
  }

  private fun doNotOperation(expression: Regex, command: String) {
    val (left, target) = expression.find(command)?.destructured
      ?: error("Couldn't parse the command $command by the $expression regex")
    score[target] = left.toInt().xor(65535)
  }
}
