package com.company.dynamicProgramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * WAP howSum(targetSum,numbers) that takes in a targetSum and an array of numbers as arguments.
 * The function should return an array containing any combination of elements that add up to exactly the target sum.
 * If there is no combination that adds up to the targetSum, then return null.
 *
 * You may use an element of the army as many times as needed.
 * You may assume that all input numbers are non-negative.
 * If there are multiple combinations possible, you may return any single one.
 */
public class HowSumMemoized {


    public static void main(String[] args) {

        Map<Integer, List<Integer>> howSumMap = new HashMap<>();
        System.out.println(howSum(701, new int[]{2,4},howSumMap));
    }

    private static List<Integer> howSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> howSumMap) {

        if (howSumMap.containsKey(targetSum))
            return howSumMap.get(targetSum);
        if (targetSum < 0)
            return null;
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        for (int num : numbers) {
            int remainder = targetSum - num;

            List<Integer> arrayCmb = howSum(remainder, numbers, howSumMap);
            if (arrayCmb != null) {
                arrayCmb.add(num);
                howSumMap.put(remainder, arrayCmb);
                return arrayCmb;
            }

        }
        howSumMap.put(targetSum, null);
        return null;
    }
}
