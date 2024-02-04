package io.plagov.advent.aoc2015

class Day09 {

  fun partOne(input: List<String>): Int {
    val routes = input.map { parseRoute(it) }
    val points = routes.flatMap { listOf(it.pointA, it.pointB) }.toSet()

    val shortestRoutes = mutableMapOf<String, Int>()

    points.forEach { point ->
      val remainingPoints = points.minus(point).toMutableList()
      val remainingRoutes = routes.toMutableList()
      var startPoint = point
      while (remainingPoints.iterator().hasNext()) {
        val (destination, distance) = getShortestToNextFromPoint(startPoint, remainingRoutes)
        shortestRoutes[point] = (shortestRoutes[point] ?: 0) + distance
        remainingPoints.remove(destination)
        remainingRoutes.removeAll { startPoint in listOf(it.pointA, it.pointB) }
        startPoint = destination
      }
    }

    return shortestRoutes.entries.minBy { it.value }.value
  }

  private fun getShortestToNextFromPoint(point: String, routes: List<Route>): Pair<String, Int> {
    val fullRoute = routes
      .filter { route -> point in listOf(route.pointA, route.pointB) }
      .minBy { it.distance }
    val destination = listOf(fullRoute.pointA, fullRoute.pointB).minus(point).single()
    return Pair(destination, fullRoute.distance)
  }

  private fun parseRoute(route: String): Route {
    val regex = """(\w+) to (\w+) = (\d+)""".toRegex()
    val (pointA, pointB, distance) = regex.find(route)?.destructured ?: error("Fail to parse the route $route")
    return Route(pointA, pointB, distance.toInt())
  }

  fun partTwo(input: List<String>): Int {
    TODO("Not yet implemented")
  }
}

data class Route(
  val pointA: String,
  val pointB: String,
  val distance: Int
)
