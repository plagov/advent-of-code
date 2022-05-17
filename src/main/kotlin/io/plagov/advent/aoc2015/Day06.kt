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

      when (command) {
        "turn on" -> turnLightsOn(start, end)
        "turn off" -> turnLightsOff(start, end)
        "toggle" -> toggleLights(start, end)
        else -> error("Unknown command: $command")
      }

    }

    return grid.flatMap { it.asIterable() }.count { it == 1 }
  }

  private fun turnLightsOn(startPoint: String, endPoint: String) {
    val (startX, startY) = startPoint.split(",").map { it.toInt() }
    val (endX, endY) = endPoint.split(",").map { it.toInt() }
    for (x in startX..endX) {
      for (y in startY..endY) {
        grid[x][y] = 1
      }
    }
  }

  private fun turnLightsOff(startPoint: String, endPoint: String) {
    val (startX, startY) = startPoint.split(",").map { it.toInt() }
    val (endX, endY) = endPoint.split(",").map { it.toInt() }
    for (x in startX..endX) {
      for (y in startY..endY) {
        grid[x][y] = 0
      }
    }
  }

  private fun toggleLights(startPoint: String, endPoint: String) {
    val (startX, startY) = startPoint.split(",").map { it.toInt() }
    val (endX, endY) = endPoint.split(",").map { it.toInt() }
    for (x in startX..endX) {
      for (y in startY..endY) {
        if (grid[x][y] == 0) {
          grid[x][y] = 1
        } else {
          grid[x][y] = 0
        }
      }
    }
  }

}
