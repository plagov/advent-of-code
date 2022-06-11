package io.plagov.advent.aoc2015

class Day07 {

  private var score = mutableMapOf<String, Int?>()

  private val andOperationBetweenSignalsRegex = """^(\w+) AND (\w+) -> (\w+)$""".toRegex()

  fun partOne(input: List<String>, searchingKey: String): Int {
    initializeAllKeys(input)

    while (score[searchingKey] == null) {
      Signals(input)
        .assignDigitsToKeys()
        .doShiftOperations()
        .doNotOperations()
        .doOrOperations()
        .doAndOperationsBetweenKeys()
        .doAndOperationWithDigit()
        .doAssignmentFromAnotherKey()
    }
    return score[searchingKey] ?: error("No value found for key '$searchingKey'")
  }

  private fun initializeAllKeys(input: List<String>) {
    val reg = """(.*) -> (\w+)""".toRegex()

    score = input.associateTo(score) { inp ->
      val (_, key) = reg.find(inp)?.destructured ?: error("Couldn't parse the line $inp by regex $reg")
      key to null
    }
  }


  @JvmInline
  private value class Signals(val value: List<String>)

  private fun Signals.assignDigitsToKeys(): Signals {
    val assignValueRegex = """^(\d+) -> (\w+)$""".toRegex()

    this.value.filter { it.matches(assignValueRegex) }.forEach { cmd ->
      val (value, target) = assignValueRegex.find(cmd)?.destructured ?: error("Error parsing")
      if (score[target] == null) {
        score[target] = value.toInt()
      }
    }
    return this
  }

  private fun Signals.doShiftOperations(): Signals {
    val knownKeysAfterAssignment = score.entries.filter { it.value != null }.map { it.key }
    val shiftReg = """^(\w+) ([L|R]SHIFT) (\d+) -> (\w+)${'$'}""".toRegex()
    this.value
      .filter { it.matches(shiftReg) }
      .filter { it.substringBefore(" ") in knownKeysAfterAssignment }
      .forEach { cmd ->
        val (left, operation, bitCount, target) = shiftReg.find(cmd)?.destructured ?: error("Error parsing")
        val result = getShiftResult(operation, score[left]!!, bitCount.toInt())
        if (score[target] == null) {
          score[target] = result
        }
      }
    return this
  }

  private fun Signals.doNotOperations(): Signals {
    val knownKeysAfterTwoSteps = score.entries.filter { it.value != null }.map { it.key }
    val notReg = """^NOT (\w+) -> (\w+)$""".toRegex()
    this.value
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
    return this
  }

  private fun Signals.doOrOperations(): Signals {
    val knownKeysAfterThreeSteps = score.entries.filter { it.value != null }.map { it.key }
    val orReg = """^(\w+) OR (\w+) -> (\w+)$""".toRegex()
    this.value
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
    return this
  }

  private fun Signals.doAndOperationsBetweenKeys(): Signals {
    val knownKeysAfterFourSteps = score.entries.filter { it.value != null }.map { it.key }
    this.value
      .filter { it.matches(andOperationBetweenSignalsRegex) }
      .filter {
        val (left, right, _) = andOperationBetweenSignalsRegex.find(it)?.destructured ?: error("213")
        knownKeysAfterFourSteps.containsAll(listOf(left, right))
      }
      .forEach { cmd ->
        val (left, right, target) = andOperationBetweenSignalsRegex.find(cmd)?.destructured ?: error("213")
        if (score[target] == null) {
          score[target] = score[left]!! and score[right]!!
        }
      }
    return this
  }

  private fun Signals.doAndOperationWithDigit(): Signals {
    val knownKeysAfterFiveSteps = score.entries.filter { it.value != null }.map { it.key }
    val andWithDigitReg = """^(\d+) AND (\w+) -> (\w+)$""".toRegex()
    this.value
      .filter { it.matches(andWithDigitReg) }
      .filter {
        val (_, right, _) = andOperationBetweenSignalsRegex.find(it)?.destructured ?: error("213")
        right in knownKeysAfterFiveSteps
      }
      .forEach { cmd ->
        val (left, right, target) = andOperationBetweenSignalsRegex.find(cmd)?.destructured ?: error("213")
        if (score[target] == null) {
          score[target] = left.toInt() and score[right]!!
        }
      }
    return this
  }

  private fun Signals.doAssignmentFromAnotherKey(): Signals {
    val knownKeysAfterSixSteps = score.entries.filter { it.value != null }.map { it.key }
    val assignFromAnotherReg = """^(\w+) -> (\w+)$""".toRegex()
    this.value
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
    return this
  }

  private fun getShiftResult(operation: String, left: Int, bitCount: Int) =
    when (operation) {
      "RSHIFT" -> left shr bitCount
      "LSHIFT" -> left shl bitCount
      else -> error("Unknown operation: $operation")
    }

}
