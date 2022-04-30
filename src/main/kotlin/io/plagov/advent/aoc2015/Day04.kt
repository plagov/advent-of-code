package io.plagov.advent.aoc2015

import java.security.MessageDigest

class Day04 {

  fun partOne(input: String) = findHashForInputStartingWithPrefix(input, "00000")

  fun partTwo(input: String) = findHashForInputStartingWithPrefix(input, "000000")

  private fun findHashForInputStartingWithPrefix(input: String, prefix: String): Int {
    var number = 1
    while (true) {
      val hash = "$input$number".toMD5()
      if (hash.startsWith(prefix)) {
        break
      }
      number++
    }
    return number
  }

  private fun String.toMD5(): String {
    val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
    return bytes.toHex()
  }

  private fun ByteArray.toHex(): String {
    return joinToString("") { "%02x".format(it) }
  }
}
