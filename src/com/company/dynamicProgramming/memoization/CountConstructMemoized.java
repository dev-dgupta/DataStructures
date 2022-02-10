package com.company.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

/*
 * WAP countConstruct(target,wordBank) that takes in a target and an array of strings as arguments.
 * The function should return the number of ways to construct
 * the target by concatenating elements of the wordBank array.
 *
 * You may reuse an element of the wordbank as many times as needed.
 */
public class CountConstructMemoized {

    public static void main(String[] args) {
        Map<String, Integer> countConstructMap = new HashMap<>();
        System.out.println(countConstruct("abcdef", new String[]{"ab", "def", "cd", "f", "e", "ce", "abc"}, countConstructMap));
        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl", "e", "abc"}, countConstructMap));
        System.out.println(countConstruct("enterapotentpot", new String[]{"p", "a", "ent", "enter", "ot", "t","o"}, countConstructMap));

    }

    private static int countConstruct(String target, String[] wordBank, Map<String, Integer> countConstructMap) {

        if (countConstructMap.containsKey(target))
            return countConstructMap.get(target);

        if (target.isEmpty())
            return 1;
        int noOfWays = 0;
        for (String word : wordBank) {

            if (target.equalsIgnoreCase(word))
                return 1;

            if (!target.startsWith(word))
                continue;

            String remainder = target.substring(word.length());
            noOfWays = noOfWays + countConstruct(remainder, wordBank, countConstructMap);
        }

        countConstructMap.put(target, noOfWays);
        return noOfWays;
    }

}
