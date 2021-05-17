package com.make.medium;

/**
 * @author make
 * @create 2021-05-17
 */
public class M654_MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recurse(nums, 0, nums.length - 1);
    }

    public TreeNode recurse(int[] nums, int left, int right) {
        if (left > right) return null;
        int m = nums[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > m) {
                m = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(m);
        node.left = recurse(nums, left, index - 1);
        node.right = recurse(nums, index + 1, right);
        return node;
    }

}
