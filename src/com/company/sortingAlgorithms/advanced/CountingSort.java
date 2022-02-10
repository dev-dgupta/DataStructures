package com.company.sortingAlgorithms.advanced;

import java.util.*;

/*
* The counting sort, does not require comparison.
* Instead, you create an integer array whose index range covers the entire range of values in your array to sort.
* Each time a value occurs in the original array, you increment the counter at that index.
* At the end, run through your counting array, printing the value of each non-zero valued index that number of times.

Example

All of the values are in the range , so create an array of zeros, . The results of each iteration follow:

i	arr[i]	result
0	1	[0, 1, 0, 0]
1	1	[0, 2, 0, 0]
2	3	[0, 2, 0, 1]
3	2	[0, 2, 1, 1]
4	1	[0, 3, 1, 1]
The frequency array is [0,3,1,1] . These values can be used to create the sorted array as well: sorted=[1,1,1,2,3].
*
* */
public class CountingSort {

    public static void sortByFreq(List<Integer> arr) {

        int maxE = -1;
        // Find the maximum element of arr
        for (int i = 0; i < arr.size(); i++) {
            maxE = Math.max(maxE, arr.get(i));
        }
        //maximum size of frequency array depends on the largest element in the unsorted array
        Integer[] freqArr=new Integer[maxE];
        //fill all elements with default value 0
        Arrays.fill(freqArr,0);

        //calculate thefrequency of the array
        for(Integer number:arr){
            freqArr[number]=freqArr[number]+1;
        }

        printSortedArray(freqArr);
    }

    private static void printSortedArray(Integer[] freqArr) {
        for(int i = 0; i< freqArr.length; i++){
            for(int j = 0; j< freqArr[i]; j++){
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();
        Collections.addAll(arr,6,3,2,5,7,3,1,9,8,7,3,5,6,8,4,8,6,5,7,1,6,8,3,8,2,5,8,1,5,6,9,5,3,9,8,6,7,9);

        sortByFreq(arr);
    }


}
