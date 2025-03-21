package io.plagov.adven.aoc2016;

import io.plagov.advent.aoc2016.Day01;
import org.junit.jupiter.api.Test;
import util.FileUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {

    @Test
    void solveFirst() {
        Day01 day1 = new Day01();
        String input = FileUtil.readInputFileAsString("2016/day01.txt");
        assertEquals(332, day1.partOne(input));
    }
}
