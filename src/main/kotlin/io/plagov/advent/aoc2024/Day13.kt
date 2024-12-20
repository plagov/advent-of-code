package io.plagov.advent.aoc2024

class Day13 {

  private val reg = """Button A: X\+(?<abuttonx>\d+), Y\+(?<abuttony>\d+)\nButton B: X\+(?<bbuttonx>\d+), Y\+(?<bbuttony>\d+)\nPrize: X=(?<pricex>\d+), Y=(?<pricey>\d+)""".toRegex()

  private val buttonACost = 3
  private val buttonBCost = 1

  fun partOne(input: String): Int {
    val blocks = input.split("\n\n")
      .map { block -> parseBlock(block) }
      .map { clawMachine ->  calculate(clawMachine) }
      .sumOf { cost -> cost ?: 0 }

    return blocks
  }

  private fun calculate(clawMachine: ClawMachine): Int? {
    val (buttonA, buttonB, prize) = clawMachine

    val pressACunt = (prize.x * buttonB.y - prize.y * buttonB.x) / (buttonA.x * buttonB.y - buttonA.y * buttonB.x)
    val pressBCount = (buttonA.x * prize.y - buttonA.y * prize.x) / (buttonA.x * buttonB.y - buttonA.y * buttonB.x)

    if (pressACunt * buttonA.x + pressBCount * buttonB.x == prize.x &&
      pressACunt * buttonA.y + pressBCount * buttonB.y == prize.y) {
      val totalCost = pressACunt * buttonACost + pressBCount * buttonBCost

      return totalCost
    }

    return null
  }

  private fun parseBlock(block: String): ClawMachine {
    val match = reg.find(block)!!
    val buttonA = Button(
      x = match.groups["abuttonx"]?.value?.toInt()!!,
      y = match.groups["abuttony"]?.value?.toInt()!!
    )

    val buttonB = Button(
      x = match.groups["bbuttonx"]?.value?.toInt()!!,
      y = match.groups["bbuttony"]?.value?.toInt()!!
    )

    val prize = PrizeLocation(
      x = match.groups["pricex"]?.value?.toInt()!!,
      y = match.groups["pricey"]?.value?.toInt()!!
    )

    return ClawMachine(buttonA, buttonB, prize)

  }

  data class Button(val x: Int, val y: Int)
  data class PrizeLocation(val x: Int, val y: Int)
  data class ClawMachine(val buttonA: Button, val buttonB: Button, val prize: PrizeLocation)
}
