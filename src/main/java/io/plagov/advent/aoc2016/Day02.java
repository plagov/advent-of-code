package io.plagov.advent.aoc2016;

import java.util.List;

public class Day02 {

    private final int[][] keypad = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    private final Point point = new Point(1, 1);

    public String partOne(List<String> input) {
        StringBuilder result = new StringBuilder();

        for (String setOfCommands : input) {
            var commands = setOfCommands.split("");
            for (String command : commands) {
                switch (command) {
                    case "U" -> moveUp();
                    case "R" -> moveRight();
                    case "D" -> moveDown();
                    case "L" -> moveLeft();
                }
            }

            result.append(keypad[point.row][point.col]);
        }

        return result.toString();
    }

    private void moveLeft() {
        if (point.col > 0) {
            point.col -= 1;
        }
    }

    private void moveDown() {
        if (point.row < 2) {
            point.row += 1;
        }
    }

    private void moveRight() {
        if (point.col < 2) {
            point.col += 1;
        }
    }

    private void moveUp() {
        if (point.row > 0) {
            point.row -= 1;
        }
    }

    private static class Point {
        public int row;
        public int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
