package io.plagov.advent.aoc2016;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

    private static final String pattern = "\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)";

    public long partOne(List<String> input) {
        return input.stream()
                .map(Day03::parseTriangle)
                .filter(Day03::isValidTriangle)
                .count();
    }

    private static boolean isValidTriangle(Triangle triangle) {
        var a = triangle.first() + triangle.second() > triangle.third();
        var b = triangle.first() + triangle.third() > triangle.second();
        var c = triangle.second() + triangle.third() > triangle.first();

        return a && b && c;
    }

    private static Triangle parseTriangle(String triangle) {
        var compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(triangle);

        if (matcher.matches()) {
            var first = Integer.parseInt(matcher.group(1));
            var second = Integer.parseInt(matcher.group(2));
            var third = Integer.parseInt(matcher.group(3));

            return new Triangle(first, second, third);
        }

        throw new IllegalStateException("Couldn't parse the line: " + triangle);

    }

    private record Triangle(int first, int second, int third) { }
}
