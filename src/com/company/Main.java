package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int arr[] = {2, 7, 1, 2, 4, 8};

        int sum = Arrays.stream(arr).sum();

        if (sum % 3 != 0) {
            System.out.println("Impossible");
        } else {
            int target = sum / 3;


        }
    }

}
