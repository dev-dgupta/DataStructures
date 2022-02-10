package com.company.dynamicProgramming.tabulation;

import java.util.Arrays;

public class FibonacciTabulation {

    public static void main(String[] args) {

        int n = 34    ;

        int[] table = new int[n + 1];
        Arrays.fill(table, 0);
        table[1] = 1;

        for (int i = 0; i < n; i++) {
            table[i + 1] = table[i] + table[i + 1];
            if (i < n-1) {
                table[i + 2] = table[i] + table[i + 2];
            }
        }

        System.out.println(table[n]);
    }
}
