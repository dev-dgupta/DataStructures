package com.company.dynamicProgramming.memoization;


import java.util.HashMap;
import java.util.Map;

/*
 * Say that you are a traveler on a 2D grid.
 * You begin in the top-left corner and your goal is to travel to the bottom-right corner.
 * You may only move down or right.
 * In how many ways can you travel to the goal on a grid with dimension m*n?
 *
 * */
public class GridTravellerMemoized {

    public static void main(String[] args) {

        Map<String, Long> sum = new HashMap<>();
        System.out.println(gridTraveller(13, 31, sum));


    }

    private static long gridTraveller(int m, int n, Map<String, Long> sum) {
        String key = m + "," + n;
        if (sum.containsKey(key))
            return sum.get(key);
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1)
            return 1;

        long currSum = gridTraveller(m, n - 1, sum) + gridTraveller(m - 1, n, sum);
        sum.put(key, currSum);
        return currSum;
    }
}
