package io.plagov.advent.aoc2015

class Day09 {

  fun partOne(input: List<String>): Int {
    return getRoutesWithDistances(input, ::getShortestToNextFromPoint).entries.minBy { it.value }.value
  }

  fun partTwo(input: List<String>): Int {
    return getRoutesWithDistances(input, ::getLongestToNextFromPoint).entries.maxBy { it.value }.value
  }

  private fun getRoutesWithDistances(
    input: List<String>,
    getNextFromPoint: (String, MutableList<Route>) -> Pair<String, Int>
  ): Map<String, Int> {
    val routes = input.map { parseRoute(it) }
    val points = routes.flatMap { listOf(it.pointA, it.pointB) }.toSet()

    val shortestRoutes = mutableMapOf<String, Int>()

    points.forEach { point ->
      val remainingPoints = points.minus(point).toMutableList()
      val remainingRoutes = routes.toMutableList()
      var startPoint = point
      while (remainingPoints.iterator().hasNext()) {
        val (destination, distance) = getNextFromPoint(startPoint, remainingRoutes)
        shortestRoutes[point] = (shortestRoutes[point] ?: 0) + distance
        remainingPoints.remove(destination)
        remainingRoutes.removeAll { startPoint in listOf(it.pointA, it.pointB) }
        startPoint = destination
      }
    }

    return shortestRoutes
  }

  private fun getShortestToNextFromPoint(point: String, routes: List<Route>): Pair<String, Int> {
    val fullRoute = routes
      .filter { route -> point in listOf(route.pointA, route.pointB) }
      .minBy { it.distance }
    val destination = listOf(fullRoute.pointA, fullRoute.pointB).minus(point).single()
    return Pair(destination, fullRoute.distance)
  }

  private fun getLongestToNextFromPoint(point: String, routes: List<Route>): Pair<String, Int> {
    val fullRoute = routes
      .filter { route -> point in listOf(route.pointA, route.pointB) }
      .maxBy { it.distance }
    val destination = listOf(fullRoute.pointA, fullRoute.pointB).minus(point).single()
    return Pair(destination, fullRoute.distance)
  }

  private fun parseRoute(route: String): Route {
    val regex = """(\w+) to (\w+) = (\d+)""".toRegex()
    val (pointA, pointB, distance) = regex.find(route)?.destructured
      ?: error("Fail to parse the route $route")
    return Route(pointA, pointB, distance.toInt())
  }
}

data class Route(
  val pointA: String,
  val pointB: String,
  val distance: Int
)
