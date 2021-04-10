package com.make.medium;

/**
 * @author make
 * @create 2021-04-10
 */
public class M695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;
        int col = grid[0].length;
        int row = grid.length;
        if (row < 1 || col < 1) return 0;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) return 0;
        grid[row][col] = 0;  // set to zero, avoid sum multiply
        int num = 1;
        num += dfs(row - 1, col, grid);
        num += dfs(row + 1, col, grid);
        num += dfs(row, col + 1, grid);
        num += dfs(row, col - 1, grid);
        return num;
    }

}
