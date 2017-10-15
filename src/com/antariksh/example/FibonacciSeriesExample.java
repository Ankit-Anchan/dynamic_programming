package com.antariksh.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ankit Anchan on 15/10/17.
 */

public class FibonacciSeriesExample {

    public static void main(String args[]) {
        int n = 50;
        CalculateFibSeries obj = new CalculateFibSeries();

        // Using naive recursion
        long startTime = System.currentTimeMillis();
        System.out.println(obj.calculateFibonacci(n));
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken = " + (endTime - startTime) + "ms");

        // Using memoize along with recursion
        startTime = System.currentTimeMillis();
        System.out.println(obj.calculateFibonacciMemoize(n, new HashMap<>()));
        endTime = System.currentTimeMillis();
        System.out.println("Total time taken = " + (endTime - startTime) + "ms");

        // Using Simple For loop with memoize and no recursion
        startTime = System.currentTimeMillis();
        System.out.println(obj.calculateFibonacciMemoizeNoRecursion(n));
        endTime = System.currentTimeMillis();
        System.out.println("Total time taken = " + (endTime - startTime) + "ms");
    }
}

class CalculateFibSeries {

    /**
     * Example of fibonacci series 1 2 3 5 8 13 21 34 55 89 144 ..
     */

    long calculateFibonacci(int n) {
        if(n <= 2) {
            return 1;
        }

        return calculateFibonacci(n-1) + calculateFibonacci(n-2);
    }

    long calculateFibonacciMemoize(int n, Map<Integer, Long> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if(n <= 2) {
            return 1;
        }
        long sum = calculateFibonacciMemoize(n-1, memo) + calculateFibonacciMemoize(n-2, memo);
        memo.put(n, sum);
        return sum;
    }

    long calculateFibonacciMemoizeNoRecursion(int n) {
        Map<Integer, Long> memo = new HashMap<>();
        long firstSum = 0;
        long secondSum = 0;
        for (int i = 1; i <= n; i++) {
            if(i <= 2) {
                firstSum = 1;
                secondSum = 0;
            }else {
                firstSum = memo.get(i-1);
                secondSum = memo.get(i-2);
            }
            long sum = firstSum + secondSum;
            memo.put(i, sum);
        }
        return memo.get(n);
    }
}
