package graph;

/**
 * https://leetcode.com/problems/number-of-islands/
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 *   Output: 3
 */
public class NumberOfIslands {
    //Consider this 2D array as a Graph Representation where 1 represents an edge.
    //No of Disjoint parts of the graphs is the islands.
    //Start a DFS where array contains 1 and no of DFS done is the Island count.
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0)
            return 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j]=='1'){
                    islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int column) {
        int rows = grid.length;
        int columns = grid[0].length;
        if(row < 0 || column <0 || row>=rows || column>=columns||grid[row][column]=='0')
            return;
        grid[row][column]='0';
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
    }
}
