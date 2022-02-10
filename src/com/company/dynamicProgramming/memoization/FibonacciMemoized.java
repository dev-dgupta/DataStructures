package com.company.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoized {

    public static void main(String[] args) {

        int n = 81;

        Map<Integer, Long> sum = new HashMap();
        System.out.println(fib(n, sum));
    }

    private static long fib(int n, Map<Integer, Long> sum) {

        if (sum.containsKey(n))
            return sum.get(n);

        if (n <= 2)
            return 1;

        long currSum = fib(n - 1, sum) + fib(n - 2, sum);
        sum.put(n, currSum);
        return currSum;

    }


}
