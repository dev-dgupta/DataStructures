package com.company.dynamicProgramming.memoization;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/*
 * WAP bestSum(targetSum,numbers) that takes in a targetSum and an array of numbers as arguments.
 * The function should return an array containing the shortest combination of elements that add up to exactly the target sum.
 * If there is no combination that adds up to the targetSum, then return null.
 *
 * You may use an element of the army as many times as needed.
 * You may assume that all input numbers are non-negative.
 * If there are multiple combinations possible, you may return any single one.
 *
 *
 * */
public class BestSumMemoized {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> bestSumMap = new HashMap<>();
        System.out.println(bestSum(7, new int[]{1, 4, 3, 2}, bestSumMap));
    }

    private static List<Integer> bestSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> bestSumMap) {

        if (bestSumMap.containsKey(targetSum))
            return bestSumMap.get(targetSum);

        if (targetSum < 0)
            return null;
        if (targetSum == 0)
            return new ArrayList<>();

        List<Integer> shortestComb = null;

        for (int num:numbers) {
            int remainder = targetSum - num;
            List<Integer> currList = bestSum(remainder, numbers, bestSumMap);

            if (currList != null) {
                List<Integer> comb=new ArrayList<>();
                comb.addAll(currList);
                comb.add(num);
                if (shortestComb==null || shortestComb.size() > comb.size()) {
                    shortestComb = comb;
                }
            }

        }
        bestSumMap.put(targetSum, shortestComb);
        return shortestComb;
    }


}
