package com.make.simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author make
 * @create 2021-04-19
 */
public class E104_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }


    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        TreeNode node;
        int height = 0;
        while (!que.isEmpty()) {
            int n = que.size();
            while (n > 0) {
                node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                n--;
            }
            height++;
        }
        return height;
    }

}
