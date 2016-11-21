package zhang.algorithm.leetcode.question463_Island_Perimeter;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/11/21
 * Time: 下午9:21
 * To change this template use File | Settings | File Templates.
 */
public class IslandPerimeter {
    /**
     * Use dfs to deal with this problem. but when I finish it, I find it tag is hash table.
     * it's very strange!
     * <p>
     * 5833 / 5833 test cases passed.
     * Status: Accepted
     * Runtime: 132 ms
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = m != 0 ? grid[0].length : 0;
        boolean[][] isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return dfs(grid, isVisited, i, j);
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, boolean[][] isVisited, int i, int j) {
        int perim = 4;
        isVisited[i][j] = true;

        if (i > 0 && grid[i - 1][j] == 1) {
            perim -= 1;
            if (!isVisited[i - 1][j]) perim += dfs(grid, isVisited, i - 1, j);//上
        }

        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            perim -= 1;
            if (!isVisited[i + 1][j]) perim += dfs(grid, isVisited, i + 1, j);//下
        }

        if (j > 0 && grid[i][j - 1] == 1) {
            perim -= 1;
            if (!isVisited[i][j - 1]) perim += dfs(grid, isVisited, i, j - 1);//左
        }

        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            perim -= 1;
            if (!isVisited[i][j + 1]) perim += dfs(grid, isVisited, i, j + 1);//右
        }

        return perim;
    }

    /**
     * do not use dfs to deal with this problem.
     * 可以改进程序结构, 但是这样看起来最容易懂
     * 因为题意说只有一个island, 所以这样做。
     * <p>
     * 5833 / 5833 test cases passed.
     * Status: Accepted
     * Runtime: 151 ms
     *
     * @param grid
     * @return
     */
    public int islandPerimeter2(int[][] grid) {
        int m = grid.length;
        int n = m != 0 ? grid[0].length : 0;
        int perim = 0;

        for (int i = 0; i < m; i++) { //行
            perim += grid[i][0] ^ 0;
            for (int j = 1; j < n; j++) //列
                perim += grid[i][j] ^ grid[i][j - 1];
            perim += grid[i][n - 1] ^ 0;
        }

        for (int j = 0; j < n; j++) { //列
            perim += grid[0][j] ^ 0;
            for (int i = 1; i < m; i++)
                perim += grid[i][j] ^ grid[i - 1][j];
            perim += grid[m - 1][j] ^ 0;
        }
        return perim;
    }


    public static void main(String[] args) {
        IslandPerimeter test = new IslandPerimeter();
        int[][] grid = {{0, 1, 0, 0}};
        System.out.println(test.islandPerimeter(grid));
        System.out.println(test.islandPerimeter2(grid));
    }
}
