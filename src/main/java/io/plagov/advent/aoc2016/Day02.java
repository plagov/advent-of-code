package io.plagov.advent.aoc2016;

import java.util.List;

public class Day02 {

    private final String[][] keypadOne = new String[][]{
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
    };

    private final String[][] keypadTwo = new String[][] {
            {null, null, "5", null, null},
            {null, "2", "3", "4", null},
            {"5", "6", "7", "8", "9"},
            {null, "A", "B", "C", null},
            {null, null, "D", null, null}
    };

    private final Point pointOne = new Point(1, 1);
    private final Point pointTwo = new Point(2, 0);

    public String partOne(List<String> input) {
        return move(input, pointOne, keypadOne);
    }

    public String partTwo(List<String> input) {
        return move(input, pointTwo, keypadTwo);
    }

    private String move(List<String> input, Point point, String[][] keypad) {
        StringBuilder result = new StringBuilder();

        for (String setOfCommands : input) {
            var commands = setOfCommands.split("");
            for (String command : commands) {
                switch (command) {
                    case "U" -> moveUp(point, keypad);
                    case "R" -> moveRight(point, keypad);
                    case "D" -> moveDown(point, keypad);
                    case "L" -> moveLeft(point, keypad);
                }
            }

            result.append(keypad[point.row][point.col]);
        }

        return result.toString();
    }

    private void moveLeft(Point point, String[][] keypad) {
        if (point.col > 0 && keypad[point.row][point.col - 1] != null) {
            point.col -= 1;
        }
    }

    private void moveDown(Point point, String[][] keypad) {
        int edge = keypad.length - 1;
        if (point.row < edge && keypad[point.row + 1][point.col] != null) {
            point.row += 1;
        }
    }

    private void moveRight(Point point, String[][] keypad) {
        int edge = keypad.length - 1;
        if (point.col < edge && keypad[point.row][point.col + 1] != null) {
            point.col += 1;
        }
    }

    private void moveUp(Point point, String[][] keypad) {
        if (point.row > 0 && keypad[point.row - 1][point.col] != null) {
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
