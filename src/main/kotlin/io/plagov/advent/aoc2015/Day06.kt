package io.plagov.advent.aoc2015

class Day06 {

  private val rows = 1000
  private val cols = 1000

  private var grid = Array(rows) { IntArray(cols) { 0 } }

  private val regex = """([\w\s]+) ([\d\s]+,[\d\s]+) ([\w\s]+) ([\d\s]+,[\d\s]+)""".toRegex()

  fun partOne(input: List<String>): Int {

    input.forEach { instruction ->
      val (command, start, _, end) = regex.find(instruction)?.destructured
        ?: error("Couldn't parse the instruction string: $instruction")

      processCommand(command, start, end)
    }

    return grid.flatMap { it.asIterable() }.count { it == 1 }
  }

  private fun processCommand(command: String, start: String, end: String) {
    val (startX, startY) = start.split(",").map { it.toInt() }
    val (endX, endY) = end.split(",").map { it.toInt() }

    for (x in startX..endX) {
      for (y in startY..endY) {

        when (command) {
          "turn on" -> grid[x][y] = 1
          "turn off" -> grid[x][y] = 0
          "toggle" -> {
            if (grid[x][y] == 0) {
              grid[x][y] = 1
            } else {
              grid[x][y] = 0
            }
          }
        }

      }
    }
  }

}
