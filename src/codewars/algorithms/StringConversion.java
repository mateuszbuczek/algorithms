package codewars.algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

import static codewars.Assert.assertEquals;

public class StringConversion {

    public static void main(String[] args) {
        assertEquals("igPay atinlay siay oolcay", pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", pigIt("This is my string"));
    }

    private static String pigIt(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }

    private static String pigIt2(String str) {
        return Arrays.stream(str.split(" "))
                .map(s -> {
                    char c = s.charAt(0);
                    if (!Character.isLetter(c)) return s;
                    s = s.substring(1);
                    return s+c+"ay"; })
                .collect(Collectors.joining(" "));
    }
}

// https://www.codewars.com/kata/520b9d2ad5c005041100000f/train/java
