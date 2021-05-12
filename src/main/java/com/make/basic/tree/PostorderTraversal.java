package com.make.basic.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author make
 * @create 2021-05-12
 */
public class PostorderTraversal {

    public void recursionPostorderTraversal(TreeNode root) {
        if (root != null) {
            recursionPostorderTraversal(root.left);
            recursionPostorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    public void nonRecursionPostorderTraversal(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == lastVisit) {
                System.out.println(node.val + " ");
                stack.pop();
                lastVisit = node;
                node = null;
            } else {
                node = node.right;
            }
        }

    }

}
