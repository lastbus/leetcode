package com.make.medium;

/**
 * @author make
 * @create 2021-04-17
 */
public class M1325_DeleteLeavesWithAGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return root;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

}
