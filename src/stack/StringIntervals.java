package src.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

// return maximum number of intervals

public class StringIntervals {

    public static int sol(String S) {
        HashMap<Character, Character> complements = new HashMap<>();
        complements.put('L', 'R');
        complements.put('R', 'L');

        char[] inputChars = S.toCharArray();
        int intervals = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputChars.length; i++) {

            if(!stack.isEmpty() && stack.peek() == complements.get(inputChars[i])) {
                stack.pop();
            } else {
                stack.push(inputChars[i]);
            }

            if(stack.isEmpty())
                intervals++;
        }

        return intervals;
    }

    public static void main(String[] args) {
        System.out.println(sol("RLRRLLRLRRLL"));
        System.out.println(sol("RLLLRRRLLR"));
        System.out.println(sol("LLRLRLRLRLRLRR"));
    }
}
