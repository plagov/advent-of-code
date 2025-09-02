package io.plagov.advent.aoc2016;

import org.junit.jupiter.api.Test;
import util.FileUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {

    private final List<String> input = FileUtil.readInputFile("2016/day04.txt");

    @Test
    void solveFirst() {
        var day04 = new Day04();
        assertEquals(173787, day04.partOne(input));
    }

    @Test
    void solveSecond() {
        var day04 = new Day04();
        assertEquals(548, day04.partTwo(input));
    }
}
