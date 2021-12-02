package io.plagov.advent

class Day01 {

  fun numbersOfIncreases(input: List<String>): Int {
    var accumulator = 0
    val list = input.map { it.toInt() }

    for (i in 1 until list.size) {
      if (list[i] > list[i - 1]) {
        accumulator++
      }
    }

    return accumulator
  }

}
