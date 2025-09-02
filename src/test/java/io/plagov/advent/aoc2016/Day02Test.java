package io.plagov.advent.aoc2016;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.FileUtil;

import java.util.List;

class Day02Test {

    private final List<String> input = FileUtil.readInputFile("2016/day02.txt");

    @Test
    void solveFirst() {
        var day2 = new Day02();
        Assertions.assertEquals("14894", day2.partOne(input));
    }

    @Test
    void solveSecond() {
        var day2 = new Day02();
        Assertions.assertEquals("26B96", day2.partTwo(input));
    }
}
