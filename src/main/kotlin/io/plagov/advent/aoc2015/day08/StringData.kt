package io.plagov.advent.aoc2015.day08

data class StringData(
  val rawString: String,
  val rawLength: Int,
  val contentString: String = "",
  val contentLength: Int = Int.MIN_VALUE
)
