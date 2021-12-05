package io.plagov.advent

class Day02 {

  fun multiplyHorizontalWithDepth(input: List<String>): Int {
    val regex = """(.*) (\d+)""".toRegex()
    var horizontal = 0
    var depth = 0
    input.forEach { line ->
      val (command, direction) = regex.find(line)?.destructured
        ?: error("Failed to parse the line '$line' with given regex $regex")
      when (command) {
        "forward" -> horizontal += direction.toInt()
        "down" -> depth += direction.toInt()
        "up" -> depth -= direction.toInt()
      }
    }
    return horizontal * depth
  }
}
