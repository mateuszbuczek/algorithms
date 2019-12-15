package others;

public class RomanToInteger {

    public static int romanToInteger(String s){
        int result = 0;
        for(int i = s.length()-1; i>=0; i--){
           switch(s.charAt(i)) {
               case 'I': result += result < 5 ? 1 : -1; break;
               case 'V': result +=  5; break;
               case 'X': result += result < 50 ? 10: -10;  break;
               case 'L': result += 50; break;
               case 'C': result += result < 500 ? 100 : -100; break;
               case 'D': result += 500; break;
               case 'M': result += 1000; break;
           }
        }
        return result;
    }

}
