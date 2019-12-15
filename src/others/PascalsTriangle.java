package others;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        if(numRows == 0) {
            return triangle;
        }

        // init first row
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);


        // iterate over ArrayLists in ArrayList
        for(int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // first element is 1
            row.add(1);

            // iterate over row elements
            for(int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // last element is 1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(generate(2));
    }
}
