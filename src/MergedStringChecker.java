package src;


//At a job interview, you are challenged to write an algorithm to check if a given string, s, can be formed from two other strings, part1 and part2.
//
//        The restriction is that the characters in part1 and part2 should be in the same order as in s.
//        The interviewer gives you the following example and tells you to figure out the rest from the given test cases.

import java.util.HashMap;
import java.util.Map;

public class MergedStringChecker {

    public static void main(String[] args) {
        System.out.println(isMerge("asdf", "af", "d"));
    }

    public static boolean isMerge(String s, String part1, String part2) {

        char[] chars = s.toCharArray();
        char[] availableChars = part1.concat(part2).toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < availableChars.length; i++) {
            char currentChar = availableChars[i];

            if(charCount.containsKey(currentChar))
                charCount.put(currentChar, charCount.get(currentChar) + 1);
            else
                charCount.put(currentChar, 1);
        }

        for (int i = 0; i < s.length(); i++) {

            if(charCount.get(chars[i]) != null && charCount.get(chars[i]) > 0)
                charCount.put(chars[i], charCount.get(chars[i]) - 1);
            else
                return false;
        }

        return true;
    }
}
