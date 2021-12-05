package io.plagov.advent

class Day02 {

  fun multiplyHorizontalWithDepth(input: List<String>): Int {
    val regex = """(.*) (\d+)""".toRegex()

    val commands = input.map { command ->
      val (direction, value ) = regex.find(command)?.destructured
        ?: error("Failed to parse the line '$command' with given regex $regex")
      Command(direction, value.toInt())
    }

    val horizontal = commands.filter { it.direction == "forward" }.sumOf { it.value }
    val down = commands.filter { it.direction == "down" }.sumOf { it.value }
    val up = commands.filter { it.direction == "up" }.sumOf { it.value }

    return horizontal * (down - up)
  }
}

data class Command(
  val direction: String,
  val value: Int
)
