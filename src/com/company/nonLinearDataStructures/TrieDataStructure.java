package com.company.nonLinearDataStructures;

/*
* Trie is a data structure that is best to store prefixes/ dictionary.
*
* Each node having a ranking becomes an valid auto suggestion in type head features.
*
*
* */
public class TrieDataStructure {

    static class Trie {
        Trie[] children = new Trie[26];
        boolean endNode;

        Trie() {
            endNode = false;
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static void createDictionary(String[] wordDictionary) {
        for (String word : wordDictionary) {
            Trie trie = new Trie();

            //insert in form of characters
            for (int i = 0; i < word.length(); i++) {
                char charToInsertInTrie = word.charAt(i);

                int index = charToInsertInTrie - 'A';

                if (trie.children[index] == null) {
                    trie.children[index] = new Trie();
                } else {
                    trie = trie.children[index];
                }
            }
            trie.endNode = true;

        }


    }

//
//    public static boolean search(String name) {
//
//
//    }

    //Every node should has 26 alphabets and those alphabets can be stored in arraylist or map or linked list
    public static void main(String[] args) {

        String[] wordDictionary = {"Divya", "Amit", "Vaanya"};
        createDictionary(wordDictionary);
        System.out.println(wordDictionary);
//        System.out.println(search("Akansha"));

    }
}
