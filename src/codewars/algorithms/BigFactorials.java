package codewars.algorithms;

import java.math.BigInteger;
import java.util.Random;
import java.util.stream.IntStream;

import static codewars.Assert.assertEquals;

public class BigFactorials {

    private static void checkMultiply() {
        long first = Math.abs(new Random().nextLong());
        int second = Math.abs(new Random().nextInt()) % 9 + 1;
        String result = BigInteger.valueOf(first).multiply(BigInteger.valueOf(second)).toString();

        assertEquals(result, multiply(String.valueOf(first), second));
    }

    public static void checkAdd() {
        BigInteger first = new BigInteger(String.valueOf(Math.abs(new Random().nextLong())));
        BigInteger second = new BigInteger(String.valueOf(Math.abs(new Random().nextLong())));
        BigInteger sum = first.add(second);
        assertEquals(sum.toString(), add(first.toString(), second.toString()));
    }

    public static void main(String[] args) {
        checkAdd();
        checkMultiply();

        assertEquals(factorial(1	), "1");
        assertEquals(factorial(2	), "2");
        assertEquals(factorial(3	), "6");
        assertEquals(factorial(4	), "24");
        assertEquals(factorial(5	), "120");
        assertEquals(factorial(6	), "720");
        assertEquals(factorial(7	), "5040");
        assertEquals(factorial(8	), "40320");
        assertEquals(factorial(9	), "362880");
        assertEquals(factorial(10), "3628800");
        assertEquals(factorial(11), "39916800");
        assertEquals(factorial(12), "479001600");
        assertEquals(factorial(13), "6227020800");
        assertEquals(factorial(14), "87178291200");
        assertEquals(factorial(15), "1307674368000");
        assertEquals(factorial(16), "20922789888000");
        assertEquals(factorial(17), "355687428096000");
        assertEquals(factorial(18), "6402373705728000");
        assertEquals(factorial(19), "121645100408832000");
        assertEquals(factorial(20), "2432902008176640000");
    }

    public static String factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(String::valueOf)
                .reduce("1", (sum, e) -> multiply(String.valueOf(sum), String.valueOf(e)));
    }

    private static String multiply(String x, String y) {
        String shorterString = x.length() > y.length() ? y : x;
        char[] shorterStringChars = shorterString.toCharArray();
        String longerString = x.length() > y.length() ? x : y;

        return IntStream.range(0, shorterString.length())
                .mapToObj(i -> String.format(
                    "%s%s",
                    multiply(longerString, shorterStringChars[shorterString.length() - i - 1] - 48),
                    new String(new char[i]).replace('\0', '0')))
                .reduce("0", BigFactorials::add);
    }

    private static String multiply(String x, int num) {
        int additionalNextValue = 0;

        char[] chars = x.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = chars.length - 1; i >= 0; i--) {
            int sum = ((chars[i] - 48) * num) + additionalNextValue;

            result.append(sum % 10);
            additionalNextValue = sum / 10;
        }

        if (additionalNextValue != 0) {
            result.append(additionalNextValue);
        }

        return result.reverse().toString();
    }

    private static String add(String a, String b) {
        char[] arg0 = new StringBuilder(a).reverse().toString().toCharArray();
        char[] arg1 = new StringBuilder(b).reverse().toString().toCharArray();
        StringBuilder result = new StringBuilder();

        int maxSize = Math.max(arg0.length, arg1.length);
        boolean flag = false;

        for (int i = 0; i < maxSize; i++) {
            int first = 0;
            int second = 0;
            int additionalValue;

            if (arg0.length - 1 >= i) {
                first = arg0[i] - 48;
            }

            if (arg1.length - 1 >= i) {
                second = arg1[i] - 48;
            }

            additionalValue = flag ? 1 : 0;

            int sum = first + second + additionalValue;

            flag = sum / 10 == 1;
            result.append(sum % 10);
        }

        if (flag) {
            result.append("1");
        }

        return result.reverse().toString();
    }

// https://www.codewars.com/kata/557f6437bf8dcdd135000010/train/java
}
