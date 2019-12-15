package src.recursion;

import java.util.HashMap;

public class FibonacciNumber {

    public static int fibonacci(int n) {
        if(n < 2) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }


    // memoization with cache to avoid additional calculations
    HashMap<Integer, Integer> cache = new HashMap<>();

    private int fib(int N) {
        if(cache.containsKey(N)) {
            return cache.get(N);
        }
        int result;
        if(N < 2) {
            result = N;
        } else {
            result = fib(N-1) + fib(N-2);
        }
        cache.put(N, result);
        return result;
    }

}
