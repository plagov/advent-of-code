package io.plagov.advent.aoc2016;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day04 {

    private static final String pattern = "(\\D+)(\\d+)\\[(\\D+)]";

    public int partOne(List<String> input) {
        var rooms = input.stream()
                .map(this::parseRoom)
                .toList();

        return rooms.stream()
                .filter(room -> {
                    var map = getCharsWithFrequencies(room);
                    var calculatedChecksum = calculateChecksum(map);
                    return room.checksum.equals(calculatedChecksum);
                })
                .mapToInt(Room::sectorId)
                .sum();
    }

    @NotNull
    private static String calculateChecksum(HashMap<Character, Integer> map) {
        return map.entrySet()
                .stream()
                .map(entry -> new RoomName(entry.getKey(), entry.getValue()))
                .sorted(RoomName::compareTo).limit(5)
                .map(roomName -> roomName.character().toString())
                .collect(Collectors.joining());
    }

    @NotNull
    private static HashMap<Character, Integer> getCharsWithFrequencies(Room room) {
        var map = new HashMap<Character, Integer>();
        char[] chars = room.name.replace("-", "").toCharArray();
        for (char character : chars) {
            map.merge(character, 1, Integer::sum);
        }
        return map;
    }

    private Room parseRoom(String triangle) {
        var compiledPattern = Pattern.compile(pattern);
        var matcher = compiledPattern.matcher(triangle);

        if (matcher.matches()) {
            var name = matcher.group(1);
            var sectorId = Integer.parseInt(matcher.group(2));
            var checksum = matcher.group(3);

            return new Room(name, sectorId, checksum);
        }

        throw new IllegalStateException("Couldn't parse the line: " + triangle);
    }

    private record Room(String name, int sectorId, String checksum) {
    }

    private record RoomName(Character character, int occurrence) implements Comparable<RoomName> {

        @Override
        public int compareTo(@NotNull RoomName otherRoom) {
            return Objects.compare(
                    this,
                    otherRoom,
                    Comparator.comparing(RoomName::occurrence).reversed()
                            .thenComparing(RoomName::character));
        }
    }
}
