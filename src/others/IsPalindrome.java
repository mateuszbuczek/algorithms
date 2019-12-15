package others;

public class IsPalindrome {
    boolean isPalindrome1(int x) {
        if(x < 0) return false;

        int rev = 0;

        while( x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev == x;
    }

    boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while( x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return revertedNumber == x || revertedNumber/10 == x;
    }
}
