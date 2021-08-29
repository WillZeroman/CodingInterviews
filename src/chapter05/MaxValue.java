package chapter05;

import java.util.Arrays;

/**
 * 剑指 Offer 47.
 * 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class MaxValue {

    /**
     * O(row*col) O(row*col)
     * 优化1：原地修改，空间复杂度为O(1)
     * 优化2：使用一维数组，空间复杂度为O(n)
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        // dp[i][j] 表示走到grid[i][j]位置的最大值。
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        display(dp);

        return dp[row - 1][col - 1];
    }

    public int maxValue_best2(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];
        dp[0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j > 0) {
                    dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i][j];
                } else {
                    dp[j] = dp[j] + grid[i][j];
                }
            }
        }
        return dp[col - 1];
    }


    private void display(int[][] data) {
        for (int[] d : data) {
            System.out.println(Arrays.toString(d));
        }
    }

    public static void main(String[] args) {
        int[][] data = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new MaxValue().maxValue(data));
        System.out.println(new MaxValue().maxValue_best2(data));
    }
}
