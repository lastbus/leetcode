package com.make.basic.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author make
 * @create 2021-05-12
 */
public class InorderTraversal {

    public void recursionInorderTraversal(TreeNode root) {
        if (root != null) {
            recursionInorderTraversal(root.left);
            System.out.print(root.val + " ");
            recursionInorderTraversal(root.right);
        }
    }

    public void nonRecursionInorderTraversal(TreeNode root) {
        if (root == null) return;
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.val + " ");
                node = node.right;
            }
        }
    }
}
