package io.plagov.advent.aoc2015

class Day09 {

  fun partOne(input: List<String>): Int {
    val parsedRoutes = parseRoutes(input)

    val distinctPoints = parsedRoutes.flatMap { route ->
      listOf(route.from, route.to)
    }.distinct()

    return 0
  }

  private fun parseRoutes(input: List<String>): List<Route> {
    val reg = """^(\w+) to (\w+) = (\d+)$""".toRegex()
    return input.map { line ->
      val (from, to, distance) = reg.find(line)?.destructured
        ?: error("Fails to parse the line $line")
      Route(from, to, distance.toInt())
    }
  }

  private data class Route(
    val from: String,
    val to: String,
    val distance: Int
  )
}
