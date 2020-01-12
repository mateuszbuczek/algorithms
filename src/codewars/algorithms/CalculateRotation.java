package codewars.algorithms;

import static codewars.Assert.*;

public class CalculateRotation {

    public static void main(String[] args) {
        assertEquals(-1, CalculateRotation.shiftedDiff("hoop", "pooh"));
        assertEquals(2, CalculateRotation.shiftedDiff("coffee", "eecoff"));
        assertEquals(4, CalculateRotation.shiftedDiff("eecoff", "coffee"));
        assertEquals(-1, CalculateRotation.shiftedDiff("asdf", "asdfe"));
    }

    static int shiftedDiff(String first, String second){
        if (first.length() != second.length()) return -1;

        return (second + second).indexOf(first);
    }
}

// https://www.codewars.com/kata/5596f6e9529e9ab6fb000014/train/java

