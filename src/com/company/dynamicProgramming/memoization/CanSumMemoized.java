package com.company.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

/*
 * WAP canSum(targetSum,numbers) that takes in a targetSum and an array of numbers as arguments.
 * The function should return a boolean indicating whether or not it is possible to generate
 * the target sum using the numbers from the array.
 *
 * You may use an element of the army as many times as needed.
 * You may assume that all input numbers are non-negative.
 */
public class CanSumMemoized {


    public static void main(String[] args) {

        Map<Integer, Boolean> canSumMap = new HashMap<>();
        System.out.println(canSum(112, new int[]{2, 4, 6, 8}, canSumMap));

    }

    public static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> canSumMap) {

        if (canSumMap.containsKey(targetSum))
            return canSumMap.get(targetSum);
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;

        for (int i = 0; i < numbers.length; i++) {
            int remainder = targetSum - numbers[i];

            boolean ans = canSum(remainder, numbers, canSumMap);

            if (ans)
                return true;
            canSumMap.put(remainder, ans);
        }
        return false;
    }

}
