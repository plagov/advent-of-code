package io.plagov.advent.aoc2025;

import java.util.List;

public class Day01 {

    private final static int LIMIT = 99;

    private int count = 0;
    private int position = 50;

    public int partOne(List<String> input) {

        for (String rotation : input) {
            char direction = rotation.charAt(0);
            var steps = Integer.parseInt(rotation.substring(1));

            if (direction == 'L') {
                moveLeft(steps);
            } else if (direction == 'R') {
                moveRight(steps);
            }
        }

        return count;
    }

    private void moveLeft(int steps) {
        position = ((position + (-steps)) % 100 + 100) % 100;

        if (position == 0) {
            count++;
        }
    }

    private void moveRight(int steps) {
        position = ((position + steps) % 100 + 100) % 100;

        if (position == 0) {
            count++;
        }
    }
}
