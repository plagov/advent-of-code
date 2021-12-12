package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import util.readInputFile

class Day05Test : ShouldSpec({

  val day5 = Day05()

  val sampleInput = readInputFile("day05-sample.txt")
  val realInput = readInputFile("day05.txt")

  should("find number of points that repeat more than twice for sample input") {
    day5.numberOfPointsMoreThanTwo(sampleInput) shouldBe 5
  }

  should("find number of points that repeat more than twice for real input") {
    day5.numberOfPointsMoreThanTwo(realInput) shouldBe 5576
  }
})
