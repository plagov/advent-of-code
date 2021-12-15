package io.plagov.advent

class Day06 {
  fun partOne(input: List<String>): Int {
    val finalList = input.first().split(",").map { it.toInt() }.toMutableList()
    val days = 80

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

    return finalList.count()
  }
}
