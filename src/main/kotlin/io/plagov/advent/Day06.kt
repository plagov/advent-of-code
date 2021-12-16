package io.plagov.advent

/**
 * This algorithm is highly inefficient. It "does" the job for part 1,
 * but takes an infinite amount of time to complete for part 2.
 * Thus, the whole algorithm should be re-thought.
 * At the moment of comitting this, I'm lacking knowledge and experience to do that.
 * Will need to come back to it later. Until then, will keep as is.
 */
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
