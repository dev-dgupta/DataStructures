package com.company.dynamicProgramming.memoization;


import java.util.*;

/*
 * WAP allConstruct(target,wordBank) that takes in a target and an array of strings as arguments.
 * The function should return a 2D array containing all of the ways that the target can be constructed
 * by concatenating elements of the wordBank array.
 * Each element of the 2D array should represent one combination that constructs the target.
 *
 * You may reuse an element of the wordBank as many times as needed.
 */
public class AllConstructMemoized {

    public static void main(String[] args) {
        Map<String, List<List<String>>> allConstructMap = new HashMap<>();
        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl", "e", "abc"}, allConstructMap));
    }

    private static List<List<String>> allConstruct(String target, String[] wordBank, Map<String, List<List<String>>> allConstructMap) {
        //new list is constructed
        List<List<String>> allNoOfWaysList = new ArrayList<>();
        if (allConstructMap.containsKey(target))
            return allConstructMap.get(target);

        if (target.isEmpty()) {
            //if we have the empty string, it means the target could be achieved,
            // hence we add a new list inside the allWays list
            allNoOfWaysList.add(new ArrayList<>());
            return allNoOfWaysList;
        }


        for (String word : wordBank) {

            if (target.equalsIgnoreCase(word)) {
                // word is added to new list and list is added to allList
                List<String> noOfWaysList = new ArrayList<>();
                noOfWaysList.add(word);
                allNoOfWaysList.add(noOfWaysList);
                return allNoOfWaysList;
            }

            if (!target.startsWith(word))
                continue;

            String remainder = target.substring(word.length());
            //allWays list is referenced here with new name
            List<List<String>> currList = allConstruct(remainder, wordBank, allConstructMap);
            for (List<String> lst : currList) {
                // we check if the list within the allWaysList has some word
                if (!lst.isEmpty()) {
                    // if the noOfWays list is not empty, then we can create a copy of the list
                    //if the copy of list is not created, then the correct order and
                    // correct elements wont be able to define, all possible combinations could be added
                    List<String> noOfWaysList = new ArrayList<>();
                    //add the current word first
                    noOfWaysList.add(word);
                    //then add all the word in the list returned from the previous methods
                    noOfWaysList.addAll(lst);
                    //add the noOfWays list to all no of ways list
                    allNoOfWaysList.add(noOfWaysList);
                }

            }
            allConstructMap.put(remainder, currList);
        }

        return allNoOfWaysList;
    }

}
