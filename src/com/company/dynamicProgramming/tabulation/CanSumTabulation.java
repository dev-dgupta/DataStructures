package com.company.dynamicProgramming.tabulation;

import java.util.Arrays;

public class CanSumTabulation {

    public static void main(String[] args) {

        int target = 1;
        int[] numbers = {5, 4, 3};
        boolean[] targetArray = new boolean[target + 1];
        Arrays.fill(targetArray, false);
        targetArray[0] = true;

        for (int i = 0; i < targetArray.length; i++) {
            if (targetArray[i]) {
                for (int num : numbers) {
                    if (i + num <= target)
                        targetArray[i + num] = true;
                }
            }
        }
        System.out.println(targetArray[target]);
    }
}
