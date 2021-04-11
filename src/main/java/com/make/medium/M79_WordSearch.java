package com.make.medium;

/**
 * @author make
 * @create 2021-04-11
 */
public class M79_WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        if (word == null) return true;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (check(i, j, board, word, 0, visit)) return true;
                }
            }
        }
        return false;
    }

    public boolean check(int row, int col, char[][] board, String word, int index, boolean[][] visit) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (board[row][col] != word.charAt(index)) {
            return false;
        } else if (index + 1 >= word.length()) {
            return true;
        }
        visit[row][col] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = row + dir[0], newj = col + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visit[newi][newj]) {
                    boolean flag = check(newi, newj, board, word, index + 1, visit);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visit[row][col] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'C','A','A'},
                        {'A','A','A'},
                        {'B','C','D'}
                };

        String word = "AAB";

        M79_WordSearch search = new M79_WordSearch();
        System.out.println(search.exist(board, word)); // true

        board = new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        word = "ABCB";
        System.out.println(search.exist(board, word)); // false
    }
}
