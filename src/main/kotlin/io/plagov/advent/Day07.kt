package io.plagov.advent

import kotlin.math.absoluteValue

class Day07 {

  fun partOne(input: List<String>): Int {
    val crabs = input.first().split(",").map { it.toInt() }

    val fuelConsumption = mutableMapOf<Int, Int>()
    val allPossiblePositions = crabs.toSet()

    for (position in allPossiblePositions) {
      var fuel = 0
      for (crab in crabs) {
        fuel += (crab - position).absoluteValue
      }
      fuelConsumption[position] = fuel
    }

   return fuelConsumption.minByOrNull { it.value }?.value ?: error("Couldn't sort the map")
  }
}
