package io.plagov.advent.aoc2021

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import util.readInputFile

class Day02Test : ShouldSpec({

  val day2 = Day02()

  val sampleInput = readInputFile("2021/day02-sample.txt")
  val taskInput = readInputFile("2021/day02.txt")

  should("find correct number of multiplying horizontal and depth of sample input") {
    day2.multiplyHorizontalWithDepth(sampleInput) shouldBe 150
  }

  should("find correct number of multiplying horizontal and depth of task input") {
    day2.multiplyHorizontalWithDepth(taskInput) shouldBe 1480518
  }

  should("find correct multiplication of horizontal position and depth with aim for sample input") {
    day2.multiplyHorizontalAndDepthWithAim(sampleInput) shouldBe 900
  }

  should("find correct multiplication of horizontal position and depth with aim for task input") {
    day2.multiplyHorizontalAndDepthWithAim(taskInput) shouldBe 1282809906
  }
})
