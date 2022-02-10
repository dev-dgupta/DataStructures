package com.company.dynamicProgramming;

import java.util.Arrays;

/*
 * int arr={3,7,2,5,4}
 * output= BRGGB ==> 3+4=7,7=7,5+2=7
 *
 * all the corresponding tricolor should amount to equal sum
 *
 *
 * */
public class TricoloredArray {


    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 5, 4};
        int sum = Arrays.stream(arr).sum();


        if (sum % 3 == 0) {
            char[] strArr = new char[arr.length];
            int targetSum = sum / 3;
            findTriColorStr(targetSum, arr, strArr, 'R');
            findTriColorStr(targetSum, arr, strArr, 'G');
            findTriColorStr(targetSum, arr, strArr, 'B');
            System.out.println(strArr);
        } else {
            System.out.println("Impossible");
        }

    }

    private static char[] findTriColorStr(int targetSum, int[] arr, char[] strArr, char triColor) {

        if (targetSum < 0)
            return null;
        if (targetSum == 0)
            return new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int remainder = targetSum - arr[i];
            char[] currChar = findTriColorStr(remainder, arr, strArr, triColor);

            if (currChar != null) {
                strArr[i] = triColor;
                return strArr;
            }

        }

        return null;
    }
}
