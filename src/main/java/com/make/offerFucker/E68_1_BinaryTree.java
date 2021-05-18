package com.make.offerFucker;

/**
 * @author make
 * @create 2021-05-18
 */
public class E68_1_BinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode res = root;
        while (true) {
            if (p.val < res.val && q.val < res.val) {
                res = res.left;
            } else if (p.val > res.val && q.val > res.val) {
                res = res.right;
            } else {
                break;
            }
        }
        return res;
    }

}
