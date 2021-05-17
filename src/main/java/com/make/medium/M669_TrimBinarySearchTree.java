package com.make.medium;

/**
 * @author make
 * @create 2021-05-17
 */
public class M669_TrimBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        TreeNode left = trimBST(root.left, low, high);
        TreeNode right = trimBST(root.right, low, high);
        if (root.val < low) {
            return right;
        } else if (root.val > high) {
            return left;
        } else {
            root.left = left;
            root.right = right;
            return root;
        }
    }

}
