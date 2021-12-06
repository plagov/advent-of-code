package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import util.readInputFile

class Day03Test : ShouldSpec({

  val day3 = Day03()

  val sampleInput = readInputFile("day03-sample.txt")

  should("find decimal number from binary gamma and epsilon rates for sample input") {
    day3.productOfDecimalGammaAndEpsilonRates(sampleInput) shouldBe 10
  }
})
