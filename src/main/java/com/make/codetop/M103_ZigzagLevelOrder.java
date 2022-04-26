package com.make.codetop;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author make
 * @create 2022-04-26
 */
public class M103_ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Deque<TreeNode> que = new LinkedList<>();
        que.push(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            Deque<Integer> nodeList = new LinkedList<>();
            boolean flag = ++depth % 2 == 0;
            while (size-- > 0) {
                TreeNode node = que.poll();
                if (flag) {
                    nodeList.addFirst(node.val);
                } else {
                    nodeList.addLast(node.val);
                }
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            result.add((LinkedList<Integer>) nodeList);
        }

        return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
