package com.make.simple;

import java.util.LinkedList;

/**
 * @author make
 * @create 2021-04-03
 */
public class E101_SymmetricTree {

    // 递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    // 迭代，自己写的，代码太复杂
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root.left);
        stack.add(root.right);
        while (!stack.isEmpty()) {
            LinkedList<TreeNode> nextLevelNode = new LinkedList<TreeNode>();
            int size = stack.size();
            for (int i = 0; i < size / 2; i++) {
                TreeNode n1 = stack.get(i);
                TreeNode n2 = stack.get(size - 1 - i);
                if (n1 == null && n2 != null || n1 != null && n2 == null) return false;
                if (n1 == null && n2 == null) continue;
                if (n1.val != n2.val) return false;
            }
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    nextLevelNode.add(node.left);
                    nextLevelNode.add(node.right);
                }
            }
            stack = nextLevelNode;
        }
        return true;
    }

    // 迭代，官方答案。
    public boolean isSymmetric3(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root.left);
        stack.add(root.right);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.poll();
            TreeNode node2 = stack.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            stack.add(node1.left);
            stack.add(node2.right);
            stack.add(node1.right);
            stack.add(node2.left);
        }
        return true;
    }
}
