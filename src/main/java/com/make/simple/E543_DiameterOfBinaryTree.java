package com.make.simple;

/**
 * @author make
 * @create 2021-05-17
 */
public class E543_DiameterOfBinaryTree {

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return ans;
        ans = 1;
        dfs(root);
        return ans - 1;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }

}
