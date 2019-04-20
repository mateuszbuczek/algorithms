package src;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseWords {

    public static String reverseWords(final String original) {

        String[] array = original.split(" ");

        if(array.length == 0) return original;

        int i = 0;
        for(String string : array) {
            array[i] = new StringBuilder(string).reverse().toString();
        }

        return String.join(" ", array);
    }

    public static String reverseWords1(final String original) {
        return original.trim().isEmpty() ? original : Stream.of(original.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining());
    }
}
