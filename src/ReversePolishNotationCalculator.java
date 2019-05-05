package src;

import java.util.*;
import java.util.function.DoubleBinaryOperator;

public class ReversePolishNotationCalculator {

    public double evaluate(String expr) {
        if ("".equals(expr)) {
            return 0;
        }
        Stack<Double> stack = new Stack<Double>();
        for (String s : expr.split("\\s")) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                stack.push(-1 * (stack.pop() - stack.pop()));
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                stack.push(1 / (stack.pop() / stack.pop()));
            } else {
                stack.push(Double.parseDouble(s));
            }
        }
        return stack.pop();
    }
}
