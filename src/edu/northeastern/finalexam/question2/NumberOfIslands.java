package edu.northeastern.finalexam.question2;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands sol = new NumberOfIslands();

        int[][] grid1 = {{1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        assert sol.countNumberOfIslands(grid1) == 1;

        int[][] grid2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};
        assert sol.countNumberOfIslands(grid2) == 3;
    }

    /* The time complexity is O(NM) where N and M is the size of the grid. */
    public int countNumberOfIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                bfs(grid, i, j);
                ans++;
            }
        }

        return ans;
    }

    private void bfs(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        grid[x][y] = -1;
        queue.add(new int[]{x, y});

        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (!isValid(grid, nx, ny)) {
                    continue;
                }

                if (grid[nx][ny] != 1) {
                    continue;
                }

                grid[nx][ny] = -1;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    private boolean isValid(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
