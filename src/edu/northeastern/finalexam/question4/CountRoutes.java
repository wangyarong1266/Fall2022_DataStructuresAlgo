package edu.northeastern.finalexam.question4;

public class CountRoutes {

    public static void main(String[] args) {
        CountRoutes sol = new CountRoutes();
        int[][] grid1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assert sol.countRoutes(grid1) == 2;

        int[][] grid2 = {{0, 1}, {0, 0}};
        assert sol.countRoutes(grid2) == 1;
    }

    public int countRoutes(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[9].length;

        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] == 1 ? 0 : dp[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] == 1 ? 0 : dp[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n - 1][m - 1];
    }
}
