package io.plagov.advent

class Day03 {

  fun productOfDecimalGammaAndEpsilonRates(input: List<String>): Int {

    val verticalList = mutableListOf<List<String>>()

    for (indx in input.first().indices) {
      val verList = mutableListOf<String>()
      for (inp in input) {
        verList.add(inp[indx].toString())
      }
      verticalList.add(verList)
    }

    val gammaRate = verticalList.joinToString("") { listWithBits ->
      listWithBits.groupBy { it }.maxByOrNull { bitEntry -> bitEntry.value.size }?.key
        ?: error("Something went wrong with list of bits: $listWithBits")
    }.toInt(2)

    val epsilonRate = verticalList.joinToString("") { listWithBits ->
      listWithBits.groupBy { it }.minByOrNull { bitEntry -> bitEntry.value.size }?.key
        ?: error("Something went wrong with list of bits: $listWithBits")
    }.toInt(2)

    return gammaRate * epsilonRate
  }

}
