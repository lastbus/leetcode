package com.make.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author make
 * @create 2021-04-02
 */
public class M144_BinaryTreePreorderTraversal {

    // 递归，自己写的
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        list.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        list.addAll(left);
        list.addAll(right);
        return list;
    }

    // 官方答案，递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    // 官方答案，迭代
    public List<Integer> preorderTraversal3(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return list;

    }


}
