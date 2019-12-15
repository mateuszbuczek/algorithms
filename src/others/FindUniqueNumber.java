package others;

//There is an array with some numbers. All numbers are equal except for one. Try to find it!

public class FindUniqueNumber {

    public static double findUniq(double arr[]) {
        double first = arr[0];
        double second = arr[1];

        if(first != second)
            return arr[2] == first ? second : first;

        for (int i = 2; i < arr.length; i++) {

            if(arr[i] != first)
                return arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[] { 0, 0, 0.55, 0, 0}));
    }
}
