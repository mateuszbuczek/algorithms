package codewars.algorithms;

import java.util.Arrays;

import static codewars.Assert.assertEquals;

public class NextNumber {

    public static void main(String[] args) {
        assertEquals(21L, nextBiggerNumber(12));
        assertEquals(531L, nextBiggerNumber(513));
        assertEquals(2071L, nextBiggerNumber(2017));
        assertEquals(441L, nextBiggerNumber(414));
        assertEquals(414L, nextBiggerNumber(144));
    }

    public static long nextBiggerNumber(long n) {
        char [] s = String.valueOf(n).toCharArray();

        for(int i = s.length - 2; i >= 0; i--){
            for (int j = s.length-1; j > i; j--){
                if(s[i] < s[j]){
                    char tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
                    Arrays.sort(s, i+1, s.length);
                    return Long.parseLong(String.valueOf(s));
                }
            }
        }
        return -1;
    }
}

//  https://www.codewars.com/kata/55983863da40caa2c900004e/train/java
