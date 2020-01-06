package hackerrank.problemSolving.all;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatedString {

    public static void main(String[] args) {
        long count = repeatedString("aba", 10);
        return;
    }

    static long repeatedString(String s, long n) {
        long numberOfFullWords = n / s.length();
        int numberOfLeftCharacters = Math.toIntExact(n % s.length());

        long fullWordsCount = count(s, 'a') * numberOfFullWords;
        long leftCharactersCount = count(s.substring(0, numberOfLeftCharacters), 'a');

        return fullWordsCount + leftCharactersCount;
    }

    public static long count(String s, char c) {
        Matcher matcher = Pattern.compile(String.valueOf(c)).matcher(s);

        int res = 0;

        while (matcher.find()) {
            res++;
        }

        return res;
    }
}


//https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup