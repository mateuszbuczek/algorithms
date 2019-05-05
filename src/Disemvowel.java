package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Disemvowel {

    public static String disemvowel(String str) {

//        Pattern vowelPattern = Pattern.compile("[aeiou]");
//        Matcher vowelMatcher = vowelPattern.matcher(str);

      return str.replaceAll("(?i)[aeiou]", "");
    }
}
