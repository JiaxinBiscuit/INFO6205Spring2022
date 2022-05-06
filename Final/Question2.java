import java.util.LinkedList;
import java.util.Queue;

public class Question2 {
    public final static int[][] DIRECTION = {{0,1},{1,0},{0,-1},{-1,0}};

    public int numIslands(char[][] grid){
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    count++;
                    bfs(grid,i, j, visited);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j, boolean[][] visited){
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{i,j});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            visited[row][col] = true;

            for (int[] dir : DIRECTION) {
                int ii = row + dir[0];
                int jj = col + dir[1];
                if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] == '1' && visited[ii][jj] == false) {
                    queue.offer(new int[]{ii, jj});
                    visited[ii][jj] = true;
                }
            }
        }
    }


}
