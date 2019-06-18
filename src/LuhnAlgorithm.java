// Algorithm that check credit card number validity

package src;

public class LuhnAlgorithm {

    public static boolean validate(String n) {

        char[] chars = n.toCharArray();
        int sum = 0;
        int i;

        boolean isEvenLength = chars.length % 2 == 0;

        if(isEvenLength)
            i = 0;
        else
            i = 1;

        for ( ; i < chars.length; i += 2) {
            int item = Integer.valueOf(String.valueOf(chars[i]));
            item *= 2;
            if(item > 9)
                item -= 9;

            sum += item;
        }

        if(sum % 10 == 0)
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("12323"));
    }
}
