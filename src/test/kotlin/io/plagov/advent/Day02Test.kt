package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import util.readInputFile

class Day02Test : ShouldSpec({

  val day2 = Day02()

  val sampleInput = readInputFile("day02-sample.txt")
  val taskInput = readInputFile("day02.txt")

  should("find correct number of multiplying horizontal and depth of sample task") {
    day2.multiplyHorizontalWithDepth(sampleInput) shouldBe 150
  }

  should("find correct number of multiplying horizontal and depth of real task") {
    day2.multiplyHorizontalWithDepth(taskInput) shouldBe 1480518
  }
})
