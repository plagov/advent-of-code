package io.plagov.advent.aoc2016;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.FileUtil;

import java.util.List;

class Day03Test {

    private final List<String> input = FileUtil.readInputFile("2016/day03.txt");

    @Test
    void solveFirst() {
        var day03 = new Day03();
        Assertions.assertEquals(993, day03.partOne(input));
    }

    @Test
    void solveSecond() {
        var day03 = new Day03();
        Assertions.assertEquals(1849, day03.partTwo(input));
    }
}
