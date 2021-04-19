package com.make.medium;

/**
 * @author make
 * @create 2021-04-19
 */
public class M98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node,Integer low,Integer up){
        if(node == null){
            return true;
        }
        if((low != null && node.val <= low) || ( up != null && node.val >= up)){
            return false;
        }
        return helper(node.right, node.val, up) && helper(node.left, low, node.val);
    }

}
