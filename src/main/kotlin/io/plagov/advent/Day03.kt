package io.plagov.advent

class Day03 {

  fun productOfDecimalGammaAndEpsilonRates(input: List<String>): Int {
    val verticalList = convertToVerticalList(input)
    val gammaRate = mostCommonElement(verticalList).joinToString("").toInt(2)
    val epsilonRate = lessCommonElement(verticalList).joinToString("").toInt(2)
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

  private fun lessCommonElement(verticalList: MutableList<List<String>>) =
    verticalList.map { listWithBits ->
      listWithBits.groupBy { it }.minByOrNull { bitEntry -> bitEntry.value.size }?.key
        ?: error("Something went wrong with list of bits: $listWithBits")
    }

  fun productOfDecimalOxygenAndCO2ratings(input: List<String>): Int {
    val indices = input.first().indices
    var oxygenList = input.toMutableList()
    var co2List = input.toMutableList()

    for (index in indices) {
      val verticalList = convertToVerticalList(oxygenList)
      val mostCommon = if (oxygenList.size == 2 && lastIndiciesAreEqual(oxygenList)) {
        "1"
      } else {
        mostCommonElement(verticalList)[index]
      }
      oxygenList = oxygenList.filter { it[index].toString() == mostCommon }.toMutableList()
    }

    for (index in indices) {
      val verticalList = convertToVerticalList(co2List)
      val lessCommon = if (co2List.size == 2 && lastIndiciesAreEqual(co2List)) {
        "0"
      } else {
        lessCommonElement(verticalList)[index]
      }
      co2List = co2List.filter { it[index].toString() == lessCommon }.toMutableList()
    }

    val oxygen = oxygenList.joinToString("").toInt(2)
    val co2Rating = co2List.joinToString("").toInt(2)

    return oxygen * co2Rating
  }

  private fun lastIndiciesAreEqual(list: MutableList<String>) =
    list.map { it.last() }.distinct().size == 2
}
