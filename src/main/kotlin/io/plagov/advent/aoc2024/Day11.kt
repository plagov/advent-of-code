package io.plagov.advent.aoc2024

class Day11 {

  fun partOne(input: String): Int {
    var result = input.split(" ").toMutableList()

    repeat(25) {
      val newList = mutableListOf<String>()
      result.forEach { el ->
        when {
          el == "0" -> {
            newList.add("1")
          }

          el.length % 2 == 0 -> {
            val left = el.substring(0, el.length / 2)
            val right = el.substring(el.length / 2).toLong().toString()
            newList.add(left)
            newList.add(right)
          }

          else -> {
            val element = el.toLong() * 2024
            newList.add(element.toString())
          }
        }
      }
      result = newList
    }
    return result.size
  }
}
