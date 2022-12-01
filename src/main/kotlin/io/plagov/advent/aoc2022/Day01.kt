package io.plagov.advent.aoc2022

class Day01 {

  fun partOne(input: String): Int {
    val groups = input.trim().split("\n\n")
    val caloriesSums = groups.map { group ->
      val items = group.split("\n").map { it.toInt() }
      val totalAmount = items.sum()
      Elf(items, totalAmount)
    }
    return caloriesSums.maxBy { it.totalAmount }.totalAmount
  }
}

data class Elf(
  val items: List<Int>,
  val totalAmount: Int
)
