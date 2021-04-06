package com.make.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author make
 * @create 2021-04-03
 */
public class M145_BinaryTreePostorderTraversal {


    // 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }

    // 非递归
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == lastVisit) {
                list.add(node.val);
                lastVisit = node;
                stack.pop();
                node = null;
            } else {
                node = node.right;
            }
        }
        return list;
    }
}
