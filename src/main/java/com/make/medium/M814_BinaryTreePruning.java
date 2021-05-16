package com.make.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author make
 * @create 2021-05-16
 */
public class M814_BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (root.val == 0 && left == null && right == null) return null;
        root.left = left;
        root.right = right;
        return root;
    }

    public static TreeNode pruneTree2(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == lastVisit) {
                if (node.left != null && node.left.val == -1) node.left = null;
                if (node.right != null && node.right.val == -1) node.right = null;
                if (node.val == 0 && node.left == null && node.right == null) node.val = -1;
                lastVisit = node;
                stack.pop();
                node = null;
            } else {
                node = node.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(1);
        root.right = t1;
        t1.left = t3;
        t1.right = t4;
        pruneTree2(root);


    }

}
