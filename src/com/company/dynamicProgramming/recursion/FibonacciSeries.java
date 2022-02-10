package com.company.dynamicProgramming.recursion;

public class FibonacciSeries {

    /*
     * WAP fib(n) that takes in a number as an argument.
     * The function should return the nth number of the fibonacci
     * sequence.
     */

    public static void main(String[] args) {
        int n = 5;

        System.out.println(fib(n));
    }

    private static int fib(int n) {

        if (n <= 2)
            return 1;

        return fib(n - 1) + fib(n - 2);


    }


}
