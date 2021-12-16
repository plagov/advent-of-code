package io.plagov.advent

class Day06 {
  fun partOneAndTwo(input: List<String>, days: Int): Long {
    val finalList = input.first().split(",").map { it.toInt() }.toMutableList()

    for (day in 1..days) {

      val listIterator = finalList.listIterator()

      while (listIterator.hasNext()) {
        if (listIterator.next().dec() == -1) {
          listIterator.set(6)
          listIterator.add(8)
        } else {
          listIterator.set(listIterator.next().dec())
        }
      }
    }

    return finalList.count().toLong()
  }
}
