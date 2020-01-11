package codewars.binary;

import java.util.Arrays;
import java.util.stream.IntStream;

import static codewars.Assert.assertEquals;

public class CountIPAddresses {

    public static void main(String[] args) {
        assertEquals(50L, CountIPAddresses.ipsBetween("10.0.0.0", "10.0.0.50"));
        assertEquals(246L, CountIPAddresses.ipsBetween("20.0.0.10", "20.0.1.0"));
        assertEquals(256L, CountIPAddresses.ipsBetween("10.0.0.0", "10.0.1.0"));
    }

    public static long ipsBetween(String start, String end) {
        long[] from = Arrays.stream(start.split("\\.")).mapToLong(Long::parseLong).toArray();
        long[] to = Arrays.stream(end.split("\\.")).mapToLong(Long::parseLong).toArray();

        return IntStream.of(3, 2, 1, 0)
                .mapToLong(i -> (to[i] - from[i]) << 8 * (3 - i))
                .sum();
    }
}

// https://www.codewars.com/kata/526989a41034285187000de4/train/java