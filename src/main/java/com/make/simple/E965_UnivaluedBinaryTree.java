package com.make.simple;

/**
 * @author make
 * @create 2021-05-17
 */
public class E965_UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return dfs(root, root.val);
    }

    public boolean dfs(TreeNode node, int val) {
        if (node == null) return true;
        if (node.val != val) return false;
        return dfs(node.left, val) && dfs(node.right, val);
    }

}
