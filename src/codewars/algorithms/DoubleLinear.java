package codewars.algorithms;

import java.util.*;

import static codewars.Assert.assertEquals;

public class DoubleLinear {

    public static void main(String[] args) {
        assertEquals(DoubleLinear.dblLinear(10), 22);
        assertEquals(DoubleLinear.dblLinear(20), 57);
        assertEquals(DoubleLinear.dblLinear(30), 91);
        assertEquals(DoubleLinear.dblLinear(50), 175);
    }

    public static int dblLinear(int n) {
        TreeSet<Integer> dbl = new TreeSet<>();
        dbl.add(1);

        for(int x = 0; x < n; x++){
            int y = dbl.pollFirst();
            dbl.add(2*y+1);
            dbl.add(3*y+1);
        }

        return dbl.pollFirst();
    }

//  Ex: u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]
}

//  https://www.codewars.com/kata/5672682212c8ecf83e000050/train/java
