package io.plagov.advent.aoc2025;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.FileUtil;

import java.util.List;

public class Day01Test {

    private final List<String> input = FileUtil.readInputFile("2025/day01.txt");

    @Test
    void solveFirst() {
        var day1 = new Day01();
        Assertions.assertEquals(1034, day1.partOne(input));
    }
}
