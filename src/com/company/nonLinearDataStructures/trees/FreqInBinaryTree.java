package com.company.nonLinearDataStructures.trees;


import com.company.nonLinearDataStructures.trees.TreeNode;

/*
    ### PROBLEM ###
    Given a binary tree and a key. Count the frequency of the key in the BT.
                                 5
                        /               \
                    5                       6
                 /      \                 /     \
                4          3            3         5

*/
public class FreqInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(5, new TreeNode(4), new TreeNode(3)),
                new TreeNode(6, new TreeNode(3), new TreeNode(5)));

        System.out.println(countKey(root, 5)); // 3
        System.out.println(countKey(root, 6)); // 1
        System.out.println(countKey(root, 3)); // 2
        System.out.println(countKey(root, 9)); // 0
    }

    private static int countKey(TreeNode root, int key) {

        if (root == null)
            return 0;
        int count = 0;
        if (root.getVal() == key) {
            count+= 1;
        }

        count += countKey(root.getLeft(), key);
        count += countKey(root.getRight(), key);


        return count;
    }


}
