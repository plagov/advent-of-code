package io.plagov.advent.aoc2016;

public class Day01 {

    private int x = 0;
    private int y = 0;
    private String position = "N";

    public int partOne(String input) {
        String[] moves = input.trim().split(", ");

        for (String move : moves) {
            char direction = move.charAt(0);
            int steps = Integer.parseInt(move.substring(1));
            switch (direction) {
                case 'R' -> moveRight(steps);
                case 'L' -> moveLeft(steps);
            }
        }

        return Math.abs(x) + Math.abs(y);
    }

    private void moveLeft(int steps) {
        switch (position) {
            case "N" -> {
                x -= steps;
                position = "W";
            }
            case "E" -> {
                y += steps;
                position = "N";
            }
            case "S" -> {
                x += steps;
                position = "E";
            }
            case "W" -> {
                y -= steps;
                position = "S";
            }
        }
    }

    private void moveRight(int steps) {
        switch (position) {
            case "N" -> {
                x += steps;
                position = "E";
            }
            case "E" -> {
                y -= steps;
                position = "S";
            }
            case "S" -> {
                x -= steps;
                position = "W";
            }
            case "W" -> {
                y += steps;
                position = "N";
            }
        }
    }
}
