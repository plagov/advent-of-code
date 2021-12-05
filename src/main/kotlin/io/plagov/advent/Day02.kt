package io.plagov.advent

class Day02 {

  fun multiplyHorizontalWithDepth(input: List<String>): Int {
    val regex = """(.*) (\d+)""".toRegex()
    var horizontal = 0
    var depth = 0
    input.forEach { line ->
      val (command, direction) = regex.find(line)?.destructured ?: error("Something went wrong")
      when (command) {
        "forward" -> horizontal += direction.toInt()
        "down" -> depth += direction.toInt()
        "up" -> depth -= direction.toInt()
      }
    }
    println("horizontal: $horizontal")
    println("depth: $depth")
    return horizontal * depth
  }
}
