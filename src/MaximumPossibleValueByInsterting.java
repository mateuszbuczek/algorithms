package src;

public class MaximumPossibleValueByInsterting {

    public static int sol(int N) {

        char digit = '5';
        boolean positive = N >= 0 ? true: false;

        String str = Integer.toString(N);
        char[] chars = str.toCharArray();
        int smallestIndex = chars.length;

        if (positive)
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] <= digit) {
                    smallestIndex = i;
                    break;
                }

            }
        else
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] >= digit) {
                    smallestIndex = i;
                    break;
                }
            }


        return Integer.parseInt(
                 str.substring(0, smallestIndex) +
                    digit +
                    str.substring(smallestIndex));
    }

    public static void main(String[] args) {
        System.out.println(sol(-999));
    }
}
