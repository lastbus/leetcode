package com.make.medium;

/**
 * @author make
 * @create 2021-04-02
 */
public class M114_FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        if (left != null) {
            root.right = left;
            flatten(left);
            while(left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
        flatten(right);
    }

}
