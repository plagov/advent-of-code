package io.plagov.advent.aoc2015

class Day09 {

  private lateinit var parsedRoutes: List<Route>
  private var visitedRoutes = mutableListOf<Route>()
  private lateinit var finalRoute: String
  private var mapOfRoutes = mutableMapOf<Int, List<Route>>()
  private var id = 0
  private var distinctPoints = listOf<String>()

  fun partOne(input: List<String>): Int {
    parsedRoutes = parseRoutes(input)

    distinctPoints = parsedRoutes.flatMap { route ->
      listOf(route.from, route.to)
    }.distinct()

    /**
     * London
     * Dublin
     * Belfast
     */

    for (route in parsedRoutes) {
      // do route.to first
      visitedRoutes.add(route)
      mapOfRoutes.put(id, listOf(route))
      appendRouteTo(route)
      visitedRoutes.clear()
      id++

      visitedRoutes.add(route)
      mapOfRoutes.put(id, listOf(route))
      appendRouteFrom(route)
      visitedRoutes.clear()
      id++
    }

    val shortest = mapOfRoutes.map { e ->
      e.key to e.value.sumOf { it.distance }
    }.minOf { it.second }

    return shortest
  }

  private fun appendRouteFrom(route: Route) {
    val potentialRoute = parsedRoutes.firstOrNull { it !in visitedRoutes } ?: return

    if (mapOfRoutes[id]?.size!! < distinctPoints.size) { // todo condition is wrong, find another data model
      if (route.from == potentialRoute.from) {
        visitedRoutes.add(potentialRoute)
        mapOfRoutes.put(id, mapOfRoutes[id]!!.plus(potentialRoute))
        appendRouteFrom(potentialRoute)
      } else if (route.from == potentialRoute.to) {
        visitedRoutes.add(potentialRoute)
        mapOfRoutes.put(id, mapOfRoutes[id]!!.plus(potentialRoute))
        appendRouteFrom(potentialRoute)
      } else {
        visitedRoutes.add(potentialRoute)
        appendRouteFrom(route)
      }
    }
  }

  private fun appendRouteTo(route: Route) {
    val potentialRoute = parsedRoutes.firstOrNull { it !in visitedRoutes } ?: return

    if (mapOfRoutes[id]?.size!! < distinctPoints.size) { // todo condition is wrong, find another data model
      if (route.to == potentialRoute.from) {
        visitedRoutes.add(potentialRoute)
        mapOfRoutes.put(id, mapOfRoutes[id]!!.plus(potentialRoute))
        appendRouteTo(potentialRoute)
      } else if (route.to == potentialRoute.to) {
        visitedRoutes.add(potentialRoute)
        mapOfRoutes.put(id, mapOfRoutes[id]!!.plus(potentialRoute))
        appendRouteTo(potentialRoute)
      } else {
        visitedRoutes.add(potentialRoute)
        appendRouteTo(route)
      }
    }

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
