package io.plagov.advent

class Day06 {
  fun partOneAndTwo(input: List<String>, days: Int): Long {
    val finalList = input.first().split(",").map { it.toInt() }.toMutableList()

    for (day in 1..days) {

      val listIterator = finalList.listIterator()

      while (listIterator.hasNext()) {
        val number = listIterator.next().dec()
        if (number == -1) {
          listIterator.set(6)
          listIterator.add(8)
        } else {
          listIterator.set(number)
        }
      }
    }

    return finalList.count().toLong()
  }
}
