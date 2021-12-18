package io.plagov.advent

import kotlin.math.absoluteValue

class Day07 {

  fun partOne(input: List<String>): Int {
    val crabs = input.first().split(",").map { it.toInt() }

    val fuelConsumption = mutableMapOf<Int, Int>()
    val maxPosition = crabs.maxOrNull() ?: error("The list is empty")

    for (position in 1..maxPosition) {
      var fuel = 0
      for (crab in crabs) {
        fuel += (crab - position).absoluteValue
      }
      fuelConsumption[position] = fuel
    }

   return fuelConsumption.minByOrNull { it.value }?.value ?: error("Couldn't sort the map")
  }

  fun partTwo(input: List<String>): Int {
    val crabs = input.first().split(",").map { it.toInt() }

    val fuelConsumption = mutableMapOf<Int, Int>()
    val maxPosition = crabs.maxOrNull() ?: error("The list is empty")

    for (position in 1..maxPosition) {
      var fuel = 0
      for (crab in crabs) {
        val steps = (crab - position).absoluteValue
        fuel += (1..steps).sum()
      }
      fuelConsumption[position] = fuel
    }

    return fuelConsumption.minByOrNull { it.value }?.value ?: error("Couldn't sort the map")
  }
}
