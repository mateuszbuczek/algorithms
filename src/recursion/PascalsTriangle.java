// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

package src.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        helper(list, numRows);
        return list;
    }

    public static void helper(List<List<Integer>> list, int numRows) {
        if(numRows == 1) list.add(Arrays.asList(1));
        else if(numRows > 1) {
            helper(list, numRows - 1);
            List<Integer> previousList = list.get(numRows - 2);
            List<Integer> currentList = new ArrayList<>();
            for (int i = 0; i < previousList.size(); i++) {
                if(i == 0 ) currentList.add(1);
                if(i > 0) currentList.add(previousList.get(i) + previousList.get(i - 1));
                if(i == previousList.size() - 1) currentList.add(1);
            }
            list.add(currentList);
        }
    }
}
