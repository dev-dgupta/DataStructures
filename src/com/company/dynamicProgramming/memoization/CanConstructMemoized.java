package com.company.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

/*
 * WAP canConstruct(target,wordBank) that takes in a target and an array of strings as arguments.
 * The function should return a boolean indicating whether or not it is possible to construct
 * the target by concatenating elements of the wordBank array.
 *
 * You may reuse an element of the wordbank as many times as needed.
 */
public class CanConstructMemoized {

    public static void main(String[] args) {

        Map<String, Boolean> canConstructMap = new HashMap<>();
        System.out.println(canConstruct("enterapotentpot", new String[]{"p", "a", "ent", "enter", "ot", "t","o"}, canConstructMap));
    }

    private static boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> canConstructMap) {

        if (canConstructMap.containsKey(target))
            return canConstructMap.get(target);
        if (target.isEmpty())
            return true;

        for (String word : wordBank) {

            if (target.equalsIgnoreCase(word))
                return true;

            if (!target.startsWith(word))
                continue;

            String remainder = target.substring(word.length());
            boolean ans = canConstruct(remainder, wordBank, canConstructMap);
            if (ans) {
                return true;
            }
            canConstructMap.put(remainder, ans);
        }
        return false;
    }
}
