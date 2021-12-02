package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day01Test : ShouldSpec({

  val sample = """
    199
    200
    208
    210
    200
    207
    240
    269
    260
    263
    """.trimIndent()
    .split("\n")

  val day1 = Day01()

  should("should find number of increases for sample input") {
    day1.numbersOfIncreases(sample) shouldBe 7
  }
})
