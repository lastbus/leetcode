package com.make.medium;

/**
 * @author make
 * @create 2021-05-17
 */
public class M669_TrimBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int left, int right) {
        if (root == null) return root;
        if (root.val > right) return trimBST(root.left, left, right);
        if (root.val < left) return trimBST(root.right, left, right);

        root.left = trimBST(root.left, left, right);
        root.right = trimBST(root.right, left, right);
        return root;
    }

}
