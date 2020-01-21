package codewars.algorithms;

import java.util.*;

import static codewars.Assert.assertEquals;

public class ObservedPin {

    public static void main(String[] args) {
        assertEquals(Arrays.asList("5", "7", "8", "9", "0"), getPINs("8"));
        assertEquals(Arrays.asList("11", "21", "41", "12", "22", "42", "14", "24", "44"), getPINs("11"));
    }

    private static final Map<Character, String> ADJACENTS = new HashMap<Character, String>() {{
        put('1', "124");
        put('2', "2135");
        put('3', "326");
        put('4', "4157");
        put('5', "54268");
        put('6', "6953");
        put('7', "748");
        put('8', "87590");
        put('9', "986");
        put('0', "08");
    }};

    public static List<String> getPINs(String observed) {

        List<String> ans = Arrays.asList("");

        for (char c : observed.toCharArray()) {

            List<String> tmp = new ArrayList<String>();
            for (char cc : ADJACENTS.get(c).toCharArray()) {
                for (String s : ans) tmp.add(s + cc);
            }
            ans = tmp;
        }
        return ans;
    }

}

// https://www.codewars.com/kata/5263c6999e0f40dee200059d/train/java