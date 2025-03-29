package io.plagov.advent.aoc2016;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day03 {

    private static final String pattern = "\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)";

    public long partOne(List<String> input) {
        return input.stream()
                .map(Day03::parseTriangle)
                .filter(Day03::isValidTriangle)
                .count();
    }

    public long partTwo(List<String> input) {
        long count = 0;

        for (var i = 0; i < input.size() - 2; i+=3) {
            var line1 = parseTriangle(input.get(i));
            var line2 = parseTriangle(input.get(i + 1));
            var line3 = parseTriangle(input.get(i + 2));

            var triangle1 = new Triangle(line1.first(), line2.first(), line3.first());
            var triangle2 = new Triangle(line1.second(), line2.second(), line3.second());
            var triangle3 = new Triangle(line1.third(), line2.third(), line3.third());

            var validCount = Stream.of(triangle1, triangle2, triangle3)
                    .filter(Day03::isValidTriangle)
                    .count();
            count += validCount;
        }

        return count;
    }

    private static boolean isValidTriangle(Triangle triangle) {
        var a = triangle.first() + triangle.second() > triangle.third();
        var b = triangle.first() + triangle.third() > triangle.second();
        var c = triangle.second() + triangle.third() > triangle.first();

        return a && b && c;
    }

    private static Triangle parseTriangle(String triangle) {
        var compiledPattern = Pattern.compile(pattern);
        var matcher = compiledPattern.matcher(triangle);

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
