package com.company.dynamicProgramming.tabulation;

import java.util.Arrays;

public class GridTravellerTabulation {

    public static void main(String[] args) {
        int m = 4, n = 3;
        int[][] gridTraveller = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(gridTraveller[i], 0);
        }

        gridTraveller[1][1] = 1;

        for (int i = 0; i < gridTraveller.length; i++) {
            for (int j = 0; j < gridTraveller[i].length; j++) {

                if (j < n)
                    gridTraveller[i][j + 1] += gridTraveller[i][j];
                if (i < m)
                    gridTraveller[i + 1][j] += gridTraveller[i][j];

            }
        }

        System.out.println(gridTraveller[m][n]);
    }
}
