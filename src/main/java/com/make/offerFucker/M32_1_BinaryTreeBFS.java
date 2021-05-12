package com.make.offerFucker;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author make
 * @create 2021-05-12
 */
public class M32_1_BinaryTreeBFS {

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<Integer>();
        Deque<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            list.add(node.val);
            if (node.left != null) que.add(node.left);
            if (node.right != null) que.add(node.right);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
