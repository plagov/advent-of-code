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

    return -1
  }

}
