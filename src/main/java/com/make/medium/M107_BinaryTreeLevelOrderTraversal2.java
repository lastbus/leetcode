package com.make.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author make
 * @create 2021-04-03
 */
public class M107_BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listOrder = new LinkedList<List<Integer>>();
        if (root == null) return listOrder;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> list = new ArrayList<Integer>(size);
            while (size > 0) {
                size--;
                TreeNode node = stack.pop();
                if (node == null) continue;
                list.add(node.val);
                if (node.left != null) stack.add(node.left);
                if (node.right != null) stack.add(node.right);
            }
            ((LinkedList<List<Integer>>) listOrder).push(list);
        }
        return listOrder;
    }

}
