package io.plagov.advent

class Day09 {

  fun partOne(input: List<String>): Int {
    val heightmap = buildList {
      for (currentLineIndex in input.indices) {
        val currentLine = input[currentLineIndex]
        val previousLine = input.getOrNull(currentLineIndex - 1)
        val nextLine = input.getOrNull(currentLineIndex + 1)

        for (currentNumberIndex in currentLine.indices) {
          val currentNumber = currentLine[currentNumberIndex]
          val previousNumber = currentLine.getOrNull(currentNumberIndex - 1)
          val nextNumber = currentLine.getOrNull(currentNumberIndex + 1)
          val location = buildList {
            add(currentNumber)
            if (previousNumber != null) add(previousNumber)
            if (nextNumber != null) add(nextNumber)
            if (previousLine != null) add(previousLine[currentNumberIndex])
            if (nextLine != null) add(nextLine[currentNumberIndex])
          }

          add(location.map { it.digitToInt() })
        }
      }
    }

    return heightmap
      .filter { point -> point.drop(1).all { point.first() < it } }
      .sumOf { it.first() + 1 }
  }
}
