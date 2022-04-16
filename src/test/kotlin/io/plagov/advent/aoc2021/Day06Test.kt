package io.plagov.advent.aoc2021

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import util.readInputFile

class Day06Test : ShouldSpec({

  val day6 = Day06()
  
  val sampleInput = readInputFile("2021/day06-sample.txt")
  val realInput = readInputFile("2021/day06.txt")

  should("solve day 6, part 1 - sample input") {
    day6.partOneAndTwo(sampleInput, 80) shouldBe 5934
  }

  should("solve day 6, part 1 - real input") {
    day6.partOneAndTwo(realInput, 80) shouldBe 360610
  }
})
