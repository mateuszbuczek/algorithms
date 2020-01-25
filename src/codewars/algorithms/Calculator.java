package codewars.algorithms;

import codewars.Assert;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private static final Map<String, Character> signs = new HashMap<>();

    public static final String ADD = "ADD";
    public static final String SUBTRACT = "SUBTRACT";
    public static final String DIVISION = "DIVISION";
    public static final String MULTIPLICATION = "MULTIPLICATION";

    static {
        signs.put(ADD, '+');
        signs.put(SUBTRACT, '-');
        signs.put(DIVISION, '/');
        signs.put(MULTIPLICATION, '*');
    }

    public static void main(String[] args) {
        Assert.assertEquals(7, evaluate("2 / 2 + 3 * 4 - 6"));
    }

    public static Double evaluate(String expression) {
        handleExpression(expression);

        return Double.parseDouble(expression);
    }

    private static String handleExpression(String tmp) {
        String result = tmp;

        while (!noOperationLeft(result)) {
            int operationIndex = nextOperation(result);
            result = handleOperation(operationIndex, result);
        }

        return result;
    }

    private static String handleOperation(int operationIndex, String result) {


        return null;
    }

    private static int nextOperation(String tmp) {
        int a = tmp.indexOf(signs.get(ADD));
        int s = tmp.indexOf(signs.get(SUBTRACT));
        int m = tmp.indexOf(signs.get(MULTIPLICATION));
        int d = tmp.indexOf(signs.get(DIVISION));

        if (m > -1 || d > -1) {
            return m > -1 && m < d ? m : d;
        } else if (s > -1 || a > -1) {
            return s > -1 && s < a ? s : a;
        } else {
            throw new IllegalArgumentException("no signs found");
        }
    }

    private static boolean noOperationLeft(String str) {
        return str.chars().noneMatch(signs::containsValue);
    }
}

// https://www.codewars.com/kata/5235c913397cbf2508000048/java