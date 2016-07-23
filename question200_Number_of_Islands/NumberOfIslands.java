package zhang.algorithm.leetcode.question200_Number_of_Islands;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/23
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public class NumberOfIslands {
    /**
     * use the dfs way to find the nums of islands
     * <strong>result of test:</strong><br/>
     * 47 / 47 test cases passed
     * Status: Accepted
     * Runtime: 4 ms, bit 43.15%
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] flag = new boolean[m][n];
        int nums = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !flag[i][j]) {
                    nums++;
                    dfs(grid, flag, i, j);
                }
            }
        }
        return nums;
    }

    private void dfs(char[][] grid, boolean[][] flag, int i, int j) {
        flag[i][j] = true;
        //上
        if (i > 0 && grid[i - 1][j] == '1' && !flag[i - 1][j]) dfs(grid, flag, i - 1, j);
        //下
        if (i < grid.length - 1 && grid[i + 1][j] == '1' && !flag[i + 1][j]) dfs(grid, flag, i + 1, j);
        //左
        if (j > 0 && grid[i][j - 1] == '1' && !flag[i][j - 1]) dfs(grid, flag, i, j - 1);
        //右
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1' && !flag[i][j + 1]) dfs(grid, flag, i, j + 1);
    }

    /**
     * without using extra space (3 ms or 4 ms, bit 43.15% or 68)
     *
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        if (grid[i][j] <= '0') return;
        grid[i][j] = '#';
        if (i > 0) bfs(grid, i - 1, j);
        if (i < grid.length - 1) bfs(grid, i + 1, j);
        if (j > 0) bfs(grid, i, j - 1);
        if (j < grid[0].length - 1) bfs(grid, i, j + 1);
    }
}
