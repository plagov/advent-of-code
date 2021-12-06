package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import util.readInputFile

class Day03Test : ShouldSpec({

  val day3 = Day03()

  val sampleInput = readInputFile("day03-sample.txt")
  val taskInput = readInputFile("day03.txt")

  should("find decimal number from product of binary gamma and epsilon rates for sample input") {
    day3.productOfDecimalGammaAndEpsilonRates(sampleInput) shouldBe 198
  }

  should("find decimal number from product of binary gamma and epsilon rates for task input") {
    day3.productOfDecimalGammaAndEpsilonRates(taskInput) shouldBe 3009600
  }
})
