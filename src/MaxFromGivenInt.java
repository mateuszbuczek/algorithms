package src;

/*
*
* */

public class MaxFromGivenInt {

    public static int sol(int N) {

        char[] inputChars = String.valueOf(N).toCharArray();

        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 0; i < inputChars.length; i++) {
            if(inputChars[i] > inputChars[firstIndex]) {
                secondIndex = firstIndex;
                firstIndex = i;
            }
        }

        if(firstIndex == 0) {
            secondIndex = 1;
            for (int i = 2; i < inputChars.length; i++) {
                if(inputChars[i] > inputChars[secondIndex])
                    secondIndex = i;
            }
        }

        System.out.println(firstIndex + " " + secondIndex);


        char tmp;
        tmp = inputChars[0];
        inputChars[0] = inputChars[firstIndex];
        inputChars[firstIndex] = tmp;

        tmp = inputChars[1];
        inputChars[1] = inputChars[secondIndex];
        inputChars[secondIndex] = tmp;

        return Integer.parseInt(String.valueOf(inputChars));
    }

    public static void main(String[] args) {
        System.out.println(sol(123456));
        System.out.println(sol(987654));
    }
}
