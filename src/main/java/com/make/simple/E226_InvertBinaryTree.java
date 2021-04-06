package com.make.simple;

import java.util.LinkedList;

/**
 * @author make
 * @create 2021-04-03
 */
public class E226_InvertBinaryTree {

    // 递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 迭代
    public TreeNode inverTree2(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
        return root;
    }


}
