import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryArrayToDecNum {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int i = 0;
        int arrSize = binary.size();
        int val = 0;

        while(i < arrSize) {
            val += binary.get(i) * Math.pow(2, arrSize - 1 - i);
            i++;
        }
        return val;
    }

    public static int ConvertBinaryArrayToInt1(List<Integer> binary) {
        return binary.stream().reduce((x,y) -> x * 2 + y).get();
    }

    public static int ConvertBinaryArrayToInt2(List<Integer> binary) {

        int number = 0;
        for (int bit : binary) {
            number = number << 1 | bit;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0,1,0,1))));
        System.out.println(ConvertBinaryArrayToInt1(new ArrayList<>(Arrays.asList(0,1,0,1))));
        System.out.println(ConvertBinaryArrayToInt2(new ArrayList<>(Arrays.asList(0,1,0,1))));
    }
}
