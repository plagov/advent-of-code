package io.plagov.advent.aoc2016;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day05Test {

    @Test
    void solveFirst() {
        var day5 = new Day05();
        var password = day5.partOne("reyedfim");

        Assertions.assertEquals("f97c354d", password);
    }

    @Test
    void solveSecond() {
        var day5 = new Day05();
        var password = day5.partTwo("reyedfim");

        Assertions.assertEquals("863dde27", password);
    }
}
