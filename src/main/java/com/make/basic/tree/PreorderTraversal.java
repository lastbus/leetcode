package com.make.basic.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author make
 * @create 2021-05-12
 */
public class PreorderTraversal {

    public void recursionPreorderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val + " ");
        recursionPreorderTraversal(root.left);
        recursionPreorderTraversal(root.right);
    }


    public void nonRecursionPreorderTraversal(TreeNode root) {
        if (root == null) return;
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.println(node.val + " ");
                if (node != null) stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }
}
