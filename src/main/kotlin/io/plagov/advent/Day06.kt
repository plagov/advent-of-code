package io.plagov.advent

class Day06 {
  fun partOneAndTwo(input: List<String>, days: Int): Long {
    val finalList = input.first().split(",").map { it.toInt() }.toMutableList()
    for (day in 1..days) {
        for (i in 0 until finalList.size) {
          val newNumber = finalList[i].dec()
          if (newNumber == -1) {
            finalList[i] = 6
            finalList.add(8)
          } else {
            finalList[i] = newNumber
          }
        }
    }
    return finalList.count().toLong()
  }
}
