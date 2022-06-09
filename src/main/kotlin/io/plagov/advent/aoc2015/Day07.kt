package io.plagov.advent.aoc2015

class Day07 {

  private val assignValueRegex = """^(\d+) -> (\w+)$""".toRegex()

  private var score = mutableMapOf<String, Int?>()

  private fun initializeAllKeys(input: List<String>) {
    val reg = """(.*) -> (\w+)""".toRegex()

    score = input.associateTo(score) { inp ->
      val (_, key) = reg.find(inp)?.destructured ?: error("Couldn't parse the line $inp by regex $reg")
      key to null
    }
  }

  fun partOne(input: List<String>, searchingKey: String): Int {

    initializeAllKeys(input)

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

    }
    return score[searchingKey] ?: error("No value found for key '$searchingKey'")
  }

  private fun getShiftResult(operation: String, left: Int, bitCount: Int) =
    when (operation) {
      "RSHIFT" -> left shr bitCount
      "LSHIFT" -> left shl bitCount
      else -> error("Unknown operation: $operation")
    }

}
