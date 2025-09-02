package io.plagov.advent.aoc2016;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day05 {

    private static final int PASSWORD_LENGTH = 8;

    public String partOne(String input) {
        long index = 0;

        var passwordBuilder = new StringBuilder();

        while (passwordBuilder.length() != PASSWORD_LENGTH) {
            var md5 = calculateRawMD5(input + index);
            if (isMatch(md5)) {
                passwordBuilder.append(convertMD5bytesToString(md5).charAt(5));
            }
            index++;
        }

        return passwordBuilder.toString();
    }

    /**
     * Returns {@code true} if the first five hexadecimal characters of the provided raw MD5 digest are zero.
     * <p>
     * This method checks the raw MD5 bytes directly for efficiency: the first two bytes must be zero
     * (covering the first four hex characters) and the high nibble of the third byte must be zero
     * (the fifth hex character). Avoids converting the digest to a hex string.
     *
     * @param md5 raw MD5 digest bytes (expected length 16)
     * @return {@code true} if the first five hex characters are '0', {@code false} otherwise
     */
    private static boolean isMatch(byte[] md5) {
        return md5[0] == 0 && md5[1] == 0 && (md5[2] & 0xFF) < 16;
    }

    private static byte[] calculateRawMD5(String input) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    private static String convertMD5bytesToString(byte[] md5) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : md5) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
