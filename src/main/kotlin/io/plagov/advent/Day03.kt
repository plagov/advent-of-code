package io.plagov.advent

class Day03 {

  fun productOfDecimalGammaAndEpsilonRates(input: List<String>): Int {

    val verticalList = convertToVerticalList(input)

    val gammaRate = mostCommonElement(verticalList).joinToString("").toInt(2)

    val epsilonRate = verticalList.joinToString("") { listWithBits ->
      listWithBits.groupBy { it }.minByOrNull { bitEntry -> bitEntry.value.size }?.key
        ?: error("Something went wrong with list of bits: $listWithBits")
    }.toInt(2)

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

  fun productOfDecimalOxygenAndCO2ratings(input: List<String>): Int {
    val indices = input.first().indices
    var oxygenList = input.toMutableList()

    for (index in indices) {
      val verticalList = convertToVerticalList(oxygenList)
      val mostCommon = if (oxygenList.size == 2 && oxygenList.map { it.last() }.distinct().size == 2) {
        "1"
      } else {
        mostCommonElement(verticalList)[index]
      }
      oxygenList = oxygenList.filter { it[index].toString() == mostCommon }.toMutableList()
    }

    val oxygen = oxygenList.joinToString("").toInt(2)

    return -1
  }

}
