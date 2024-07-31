// 200. Number of Islands
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands += depthFirstSearch(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    public int depthFirstSearch(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        depthFirstSearch(grid, i + 1, j);
        depthFirstSearch(grid, i - 1, j);
        depthFirstSearch(grid, i, j + 1);
        depthFirstSearch(grid, i, j - 1);
        return 1;
    }
}
