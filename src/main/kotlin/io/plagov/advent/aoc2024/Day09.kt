package io.plagov.advent.aoc2024

class Day09 {

  fun partOne(input: String): Long {
    val layoutRepresentation = convertToLayout(input)
    val sortedLayout = sortLayout(layoutRepresentation)
    val checksum = calculateChecksum(sortedLayout)
    return checksum
  }

  private fun calculateChecksum(input: Array<Block>): Long {
    val firstDotIndex = input.indexOfFirst { it.value == -1 }
    return input.slice(0 until firstDotIndex).mapIndexed { index, block ->
      index.toLong() * block.value.toLong()
    }.sum()
  }

  private fun sortLayout(input: List<Block>): Array<Block> {
    val count = input.count { it.value == -1 }
    val result = input.toTypedArray()
    repeat(count) {
      val firstDotIndexedValue = result.indexOfFirst { it.value == -1 }
      val lastDigitIndex = result.indexOfLast { it.value > -1 }
      result[firstDotIndexedValue] = result[lastDigitIndex]
      result[lastDigitIndex] = Block(-1)
    }
    return result
  }

  private fun convertToLayout(input: String): List<Block> = buildList {
    var id = 0
    var value: Int

    input.trim().forEachIndexed { index, char ->
      val count = char.digitToInt()
      if (index % 2 == 0) {
        value = id
        id++
      } else {
        value = -1
      }
      repeat(count) {
        add(Block(value))
      }
    }
  }

  data class Block(val value: Int)
}

