package com.make.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author make
 * @create 2021-04-03
 */
public class M236_LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2, treeNode7, treeNode4);

        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5, treeNode6, treeNode2);

        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(1, treeNode0, treeNode8);

        TreeNode root = new TreeNode(3, treeNode5, treeNode1);

        M236_LowestCommonAncestorOfABinaryTree binaryTree = new M236_LowestCommonAncestorOfABinaryTree();
        LinkedList<TreeNode> treeParent = binaryTree.findParent(root, new TreeNode(5));
        for (TreeNode treeNode : treeParent) {
            System.out.println(treeNode.val);
        }
        System.out.println("-----");

        LinkedList<TreeNode> treeParent2 = binaryTree.findParent(root, new TreeNode(8));
        for (TreeNode treeNode : treeParent2) {
            System.out.println(treeNode.val);
        }

        System.out.println();
        System.out.println(binaryTree.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(8)).val);
    }

    // 迭代，我的解答
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        LinkedList<TreeNode> pPath = findParent(root, p);
        LinkedList<TreeNode> qPath = findParent(root, q);
        int pTail = pPath.size() - 1;
        int qTail = qPath.size() - 1;
        int prev = -1;
        while (pTail >= 0 && qTail >= 0 && pPath.get(pTail).val == qPath.get(qTail).val) {
            prev = pTail;
            pTail--;
            qTail--;
        }
        return pPath.get(prev);
    }

    private LinkedList<TreeNode> findParent(TreeNode root, TreeNode node) {
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        if (root == null || node == null) return list;
        Map<TreeNode, Boolean> visit = new HashMap<TreeNode, Boolean>();
        TreeNode tmp = root;
        while (tmp != null || !list.isEmpty()) {
            while (tmp != null && !visit.containsKey(tmp)) {
                list.push(tmp);
                visit.put(tmp, true);
                if (tmp.val == node.val) {
                    return list;
                }
                tmp = tmp.left;
            }
            tmp = list.peek().right;
            if (tmp == null || visit.containsKey(tmp)) {
                list.pop();
                tmp = list.peek().right;
            }
        }
        return list;
    }

}
