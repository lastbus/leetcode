package com.make.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author make
 * @create 2021-04-20
 */
public class M199_BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Deque<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                TreeNode node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                if (size == 1) list.add(node.val);
                size--;
            }
        }
        return list;
    }

}
