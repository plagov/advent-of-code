package io.plagov.advent.aoc2015

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import util.readInputFile

class Day05Test {

  private val day5 = Day05()

  private val taskInput = readInputFile("2015/day05.txt")

  @Test
  fun solveFirst() {
    assertEquals(238, day5.partOne(taskInput))
  }

  @Test
  fun solveSecond() {
    assertEquals(42, day5.partTwo(taskInput))
  }

  @Test
  fun testContainsNotOverlappingPairOfTwoLetters() {
    assertTrue(day5.containsNotOverlappingPairOfTwoLetters("qjhvhtzxzqqjkmpb"))
  }

  @Test
  fun testDoesNotContainNotOverlappingPairOfTwoLetters() {
    assertFalse(day5.containsNotOverlappingPairOfTwoLetters("abcdefrghi"))
  }

  @Test
  fun testContainsTwoRepeatingLettersWithSingleCharacterInBetween() {
    assertTrue(day5.containsTwoRepeatingLettersWithSingleCharacterInBetween("abcdefeghi"))
  }

  @Test
  fun testDoesNotContainTwoRepeatingLettersWithSingleCharacterInBetween() {
    assertFalse(day5.containsTwoRepeatingLettersWithSingleCharacterInBetween("abcdefrghi"))
  }

  @Test
  fun testThreeVowelsCounting() {
    assertTrue(day5.containsThreeVowels("ugknbfddgicrmopn"))
  }

  @Test
  fun testPresenceOfConsecutiveLetters() {
    assertTrue(day5.containsConsecutiveLetters("ugknbfddgicrmopn"))
  }

  @Test
  fun testStringDoesNotContainForbiddenLetters() {
    assertTrue(day5.doesNotContainForbiddenLetters("ugknbfddgicrmopn"))
  }

}
