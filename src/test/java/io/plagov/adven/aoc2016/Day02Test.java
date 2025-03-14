package io.plagov.adven.aoc2016;

import io.plagov.advent.aoc2016.Day02;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.FileUtilKt;

import java.util.List;

class Day02Test {

    private final List<String> input = FileUtilKt.readInputFile("2016/day02.txt");

    @Test
    void solveFirst() {
        var day2 = new Day02();
        Assertions.assertEquals("14894", day2.partOne(input));
    }
}
