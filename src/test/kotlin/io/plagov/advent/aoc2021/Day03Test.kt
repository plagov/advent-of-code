package io.plagov.advent.aoc2021

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.plagov.advent.aoc2021.Day03
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

  should("find decimal number from product of oxygen and CO2 ratings from sample input") {
    day3.productOfDecimalOxygenAndCO2ratings(sampleInput) shouldBe 230
  }

  should("find decimal number from product of oxygen and CO2 ratings from task input") {
    day3.productOfDecimalOxygenAndCO2ratings(taskInput) shouldBe 6940518
  }
})
