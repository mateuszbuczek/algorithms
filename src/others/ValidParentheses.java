package others;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    static boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> h = new Stack();

        for(int i = 0; i < s.length(); i++){
            // if an opening char
            if(c[i] == '(' || c[i] == '{' || c[i] == '[')
                h.push(c[i]);
            // not empty others.stack and complement closing char
            else if(!h.empty() && ((h.peek()+2) == c[i] || (h.peek()+1) == c[i]))
                h.pop();
            // empty others.stack and closing char
            else
                return false;
        }
        return h.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}

// with HashMap
class Solution {
    // Hash table that takes care of the mappings
    private HashMap<Character, Character> mappings;

    // Init hash map with mappings
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(int i =0; i< s.length(); i++) {
            char c = s.charAt(i);

            // if the current char is a closing bracket
            if(this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if(topElement != this.mappings.get(c))
                    return false;
            }
            else {
                // it it was an opening bracket, push to the others.stack.
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}