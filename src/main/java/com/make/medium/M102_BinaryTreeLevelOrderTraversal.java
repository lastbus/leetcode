package com.make.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author make
 * @create 2021-04-02
 */
public class M102_BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {


        TreeNode node = new TreeNode(15);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(20, node, node1);

        TreeNode node3 = new TreeNode(9);

        TreeNode root = new TreeNode(3, node3, node2);

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> orderList = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (size > 0) {
                size--;
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!list.isEmpty()) {
                orderList.add(list);
            }
        }
        return orderList;
    }
}
