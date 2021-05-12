package com.make.offerFucker;

/**
 * @author make
 * @create 2021-05-12
 */
public class E55_2_PingHengErChaShuLcof {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

}
