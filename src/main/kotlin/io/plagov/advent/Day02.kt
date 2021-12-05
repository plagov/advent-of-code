package io.plagov.advent

class Day02 {

  fun multiplyHorizontalWithDepth(input: List<String>): Int {
    val commands = parseInputToCommands(input)

    val horizontal = commands.filter { it.direction == "forward" }.sumOf { it.value }
    val down = commands.filter { it.direction == "down" }.sumOf { it.value }
    val up = commands.filter { it.direction == "up" }.sumOf { it.value }

    return horizontal * (down - up)
  }

  private fun parseInputToCommands(input: List<String>): List<Command> {
    val regex = """(.*) (\d+)""".toRegex()

    return input.map { command ->
      val (direction, value) = regex.find(command)?.destructured
        ?: error("Failed to parse the line '$command' with given regex $regex")
      Command(direction, value.toInt())
      }
  }

  fun multiplyHorizontalAndDepthWithAim(input: List<String>): Int {
    val commands = parseInputToCommands(input)

    var aim = 0
    var horizonal = 0
    var depth = 0

    commands.forEach { command ->
      when (command.direction) {
        "down" -> aim += command.value
        "up" -> aim -= command.value
        "forward" -> { horizonal += command.value; depth += aim * command.value }
      }
    }

    return horizonal * depth
  }
}

data class Command(
  val direction: String,
  val value: Int
)
