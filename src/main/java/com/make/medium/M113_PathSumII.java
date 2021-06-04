package com.make.medium;

import java.util.*;

/**
 * @author make
 * @create 2021-06-04
 */
public class M113_PathSumII {

    /**
     * my solution， very poor
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> nodeQue = new LinkedList<>();
        Deque<PathNode> pathSum = new LinkedList<>();
        nodeQue.offer(root);
        pathSum.offer(new PathNode(root.val));
        while (!nodeQue.isEmpty()) {
            TreeNode node = nodeQue.poll();
            PathNode paths = pathSum.poll();
            if (node.left == null && node.right == null && paths.sum == targetSum) {
                list.add(paths.paths);
            }
            if (node.left != null) {
                nodeQue.add(node.left);
                pathSum.offer(new PathNode(node.left.val + paths.sum, paths.paths, node.left.val));
            }
            if (node.right != null) {
                nodeQue.add(node.right);
                pathSum.offer(new PathNode(node.right.val + paths.sum, paths.paths, node.right.val));
            }
        }
        return list;
    }

    class PathNode {
        int sum;
        List<Integer> paths = new ArrayList<>();
        PathNode(int s, List<Integer> parents, int cur) {
            sum = s;
            for (Integer val : parents) {
                paths.add(val);
            }
            paths.add(cur);
        }
        PathNode(int s) {
            sum = s;
            paths.add(s);
        }
    }


    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    public List<List<Integer>> pathSumbfs(TreeNode root, int sum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == sum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }


    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSumdfs(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }

}
