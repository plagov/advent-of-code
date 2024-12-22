package io.plagov.advent.aoc2024

import kotlin.math.abs

class Day14 {

  private val rowCount = 103
  private val colCount = 101

  fun partOne(input: List<String>): Int {
    val robots = input.map { parseInput(it) }

    for (robot in robots) {
      repeat(100) {
        move(robot)
      }
    }

    val middleRow = rowCount / 2
    val middleCol = colCount / 2

    val topLeft = robots.count { it.pRow < middleRow && it.pCol < middleCol }
    val bottomLeft = robots.count { it.pRow > middleRow && it.pCol < middleCol }
    val topRight = robots.count { it.pRow < middleRow && it.pCol > middleCol }
    val bottomRight = robots.count { it.pRow > middleRow && it.pCol > middleCol }

    return topLeft * bottomLeft * topRight * bottomRight
  }

  private fun move(robot: Robot) {
    val rowMove = robot.pRow + robot.vRow
    val colMove = robot.pCol + robot.vCol

    if (colMove >= colCount || colMove < 0) {
      robot.pCol = abs(colCount - abs(robot.pCol + robot.vCol))
    } else {
      robot.pCol += robot.vCol
    }

    if (rowMove >= rowCount || rowMove < 0) {
      robot.pRow = abs(rowCount - abs(robot.pRow + robot.vRow))
    } else {
      robot.pRow += robot.vRow
    }
  }

  private fun parseInput(input: String): Robot {
    val regex = """p=(\d+),(\d+) v=(-?\d+),(-?\d+)""".toRegex()
    val (pX, pY, vX, vY) = regex.find(input)?.destructured
      ?: error("Failed to parse the input string $input")
    return Robot(pX.toInt(), pY.toInt(), vX.toInt(), vY.toInt())
  }

  data class Robot(var pCol: Int, var pRow: Int, var vCol: Int, var vRow: Int)
}
