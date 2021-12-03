package io.plagov.advent

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import util.readInputFile
import java.io.File

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

  val taskInput = readInputFile("day01.txt")

  val day1 = Day01()

  should("find number of increases for sample input") {
    day1.numbersOfIncreases(sample) shouldBe 7
  }

  should("find number of increases for task input") {
    day1.numbersOfIncreases(taskInput) shouldBe 1316
  }

  should("find number of sum increases of three range windows for sample input") {
    day1.numberOfSumIncreasesInThreeRangeWindow(sample) shouldBe 5
  }

  should("find number of sum increases of three range windows for task input") {
    day1.numberOfSumIncreasesInThreeRangeWindow(taskInput) shouldBe 1344
  }
})
