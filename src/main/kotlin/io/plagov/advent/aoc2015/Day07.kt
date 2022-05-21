package io.plagov.advent.aoc2015

import io.plagov.advent.aoc2015.Day07.CommandType.*

class Day07 {

  private val notRegex = """^NOT (\w+) -> (\w+)$""".toRegex()

  private val shiftRegex = """^(\w+) ([L|R]SHIFT) (\d+) -> (\w+)$""".toRegex()

  private val andOrRegex = """^(\w+) (OR|AND) (\w+) -> (\w+)$""".toRegex()

  private val assignRegex = """^(\d+) -> (\w+)$""".toRegex()

  private data class RegexRule(
    val expression: Regex,
    val type: CommandType
  )

  enum class CommandType {
    NOT, SHIFT, AND_OR, ASSIGN
  }

  private val allRegex = listOf(
    RegexRule(notRegex, NOT),
    RegexRule(shiftRegex, SHIFT),
    RegexRule(andOrRegex, AND_OR),
    RegexRule(assignRegex, ASSIGN)
  )

  private val score = mutableMapOf<String, Int>()

  /*
d: 72
e: 507
f: 492
g: 114
h: 65412
i: 65079
x: 123
y: 456
   */

  fun partOne(input: List<String>): Int {
    input.forEach { cmd ->
      val regexRule = allRegex.find { rule -> rule.expression.matches(cmd) }
        ?: error("Command '$cmd' doesn't match any regex")

      regexRule.processCommand(cmd)
    }
    return 0
  }

  private fun RegexRule.processCommand(command: String) {
    when (type) {
      NOT -> doNotOperation(expression, command)
      SHIFT -> doShiftOperation(expression, command)
      AND_OR -> doAndOrOperation(expression, command)
      ASSIGN -> doAssignOperation(expression, command)
    }

  }

  private fun doAssignOperation(expression: Regex, command: String) {
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
    val (_, start, end) = expression.find(command)?.destructured
      ?: error("Couldn't parse the command $command by the $expression regex")
    // TODO check how to do NOT operation
  }
}
