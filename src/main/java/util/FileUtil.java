package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {

    public static List<String> readInputFile(String fileName) {
        Path path = Paths.get("src/test/resources/inputs/", fileName);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static String readInputFileAsString(String fileName) {
        Path path = Paths.get("src/test/resources/inputs/", fileName);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
