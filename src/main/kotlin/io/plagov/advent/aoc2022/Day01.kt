package io.plagov.advent.aoc2022

class Day01 {

  fun partOne(input: String): Int {
    val caloriesSums = getElvesWithItems(input)
    return caloriesSums.maxBy { it.totalAmount }.totalAmount
  }

  fun partTwo(input: String): Int {
    return getElvesWithItems(input).sortedByDescending { it.totalAmount }.take(3).sumOf { it.totalAmount }
  }

  private fun getElvesWithItems(input: String): List<Elf> {
    val groups = input.trim().split("\n\n")
    val caloriesSums = groups.map { group ->
      val items = group.split("\n").map { it.toInt() }
      val totalAmount = items.sum()
      Elf(items, totalAmount)
    }
    return caloriesSums
  }
}

data class Elf(
  val items: List<Int>,
  val totalAmount: Int
)
