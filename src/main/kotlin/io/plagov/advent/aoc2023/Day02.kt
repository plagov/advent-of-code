package io.plagov.advent.aoc2023

class Day02 {

  fun partOne(input: List<String>): Int {
    val records = parseRecords(input)
    return records.filter { record ->
      record.sets.none { it.red > 12 || it.green > 13 || it.blue > 14 }
    }.sumOf { it.id }
  }

  fun partTwo(input: List<String>): Int {
    val records = parseRecords(input)
    return records.sumOf { record ->
      val maxRed = record.sets.maxOf { it.red }
      val maxGreen = record.sets.maxOf { it.green }
      val maxBlue = record.sets.maxOf { it.blue }
      maxRed * maxGreen * maxBlue
    }
  }

  private fun parseRecords(input: List<String>) = input.map { line ->
    val result = """(Game \d+): (.*)""".toRegex().find(line)!!
    val (game, sets) = result.destructured
    val id = game.substringAfter("Game ").toInt()
    val cubesSets = sets.split("; ").map { set ->
      parseSet(set)
    }
    Record(id, cubesSets)
  }

  private fun parseSet(set: String): CubesSet {
    val redPattern = """(\d+ red)""".toRegex()
    val greenPattern = """(\d+ green)""".toRegex()
    val bluePattern = """(\d+ blue)""".toRegex()
    val red = redPattern.find(set)?.value?.substringBefore(" ")?.toInt() ?: 0
    val green = greenPattern.find(set)?.value?.substringBefore(" ")?.toInt() ?: 0
    val blue = bluePattern.find(set)?.value?.substringBefore(" ")?.toInt() ?: 0
    return CubesSet(blue, red, green)
  }
}

data class Record(val id: Int, val sets: List<CubesSet>)

data class CubesSet(val blue: Int, val red: Int, val green: Int)
