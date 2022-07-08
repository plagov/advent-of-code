package io.plagov.advent.aoc2021

class Day03 {

  fun partOne(input: List<String>): Int {
    val verticalList = convertToVerticalList(input)
    val gammaRate = mostCommonElement(verticalList).joinToString("").toInt(2)
    val epsilonRate = leastCommonElement(verticalList).joinToString("").toInt(2)
    return gammaRate * epsilonRate
  }

  private fun convertToVerticalList(input: List<String>): MutableList<List<String>> {
    val verticalList = mutableListOf<List<String>>()

    for (index in input.first().indices) {
      val verList = mutableListOf<String>()
      for (inp in input) {
        verList.add(inp[index].toString())
      }
      verticalList.add(verList)
    }
    return verticalList
  }

  private fun mostCommonElement(verticalList: MutableList<List<String>>) =
    verticalList.map { listWithBits ->
      listWithBits.groupBy { it }.maxByOrNull { bitEntry -> bitEntry.value.size }?.key
        ?: error("Something went wrong with list of bits: $listWithBits")
    }

  private fun leastCommonElement(verticalList: MutableList<List<String>>) =
    verticalList.map { listWithBits ->
      listWithBits.groupBy { it }.minByOrNull { bitEntry -> bitEntry.value.size }?.key
        ?: error("Something went wrong with list of bits: $listWithBits")
    }

  fun partTwo(input: List<String>): Int {
    val oxygen = findOxygenRate(input).joinToString("").toInt(2)
    val co2Rating = findCO2Rate(input).joinToString("").toInt(2)
    return oxygen * co2Rating
  }

  private fun findOxygenRate(input: List<String>): MutableList<String> {
    val indices = input.first().indices
    val oxygenList = input.toMutableList()

    for (index in indices) {
      val verticalList = convertToVerticalList(oxygenList)
      val mostCommon = if (oxygenList.size == 2 && lastIndicesAreEqual(oxygenList)) {
        "1"
      } else {
        mostCommonElement(verticalList)[index]
      }
      oxygenList.removeIf { it[index].toString() != mostCommon }
    }
    return oxygenList
  }

  private fun findCO2Rate(input: List<String>): MutableList<String> {
    val indices = input.first().indices
    val co2List = input.toMutableList()

    for (index in indices) {
      val verticalList = convertToVerticalList(co2List)
      val lessCommon = if (co2List.size == 2 && lastIndicesAreEqual(co2List)) {
        "0"
      } else {
        leastCommonElement(verticalList)[index]
      }
      co2List.removeIf { it[index].toString() != lessCommon }
    }

    return co2List
  }

  private fun lastIndicesAreEqual(list: MutableList<String>) =
    list.map { it.last() }.distinct().size == 2
}
