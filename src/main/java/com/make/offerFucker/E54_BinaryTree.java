package com.make.offerFucker;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author make
 * @create 2021-05-18
 */
public class E54_BinaryTree {

    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = null;
        int count = 0;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            count++;
            if (count == k) return node.val;
            node = node.left;
        }
        return -1;
    }

    int res, k;
    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }

}
