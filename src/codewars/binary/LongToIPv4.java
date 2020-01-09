package codewars.binary;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongToIPv4 {

    public static void main(String[] args) {
        boolean result = longToIP(2149583361L).equals("128.32.10.1");

        return;
    }

    public static String longToIP(long ip) {
        return IntStream.of(3, 2, 1, 0)
                .map(item -> (int) (ip >> 8 * item & 0xFF))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("."));
    }
}

// https://www.codewars.com/kata/52e88b39ffb6ac53a400022e/train/java