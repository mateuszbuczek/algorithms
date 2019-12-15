package others;



import java.util.Arrays;

public class HighestAndLowest {

//  In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
    public static String HighAndLow(String numbers) {
        String[] str = numbers.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String s : str) {
            int num = Integer.parseInt(s);

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return "" + max + " " + min;
    }

    public static String HighAndLow1(String numbers) {

        int min = Arrays.stream(numbers.split(" "))
                .mapToInt(i -> Integer.parseInt(i))
                .min()
                .getAsInt();

        int max = Arrays.stream(numbers.split(" "))
                .mapToInt(i -> Integer.parseInt(i))
                .max()
                .getAsInt();

        return String.format("%d %d", max, min);
    }

//    Write a function that returns both the minimum and maximum number of the given list/array.
    public static int[] minMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int item : arr) {
            min = Math.min(min, item);
            max = Math.max(max, item);
        }

        return new int[] {min, max};
    }

    public static int[] minMax1(int[] arr) {
        int min = Arrays.stream(arr)
                .min()
                .getAsInt();
        int max = Arrays.stream(arr)
                .max()
                .getAsInt();

        return new int[] {min, max};
    }

}
