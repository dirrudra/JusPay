package questions;
import java.util.*;

public class MazeSolver {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean solveMaze(int[][] maze, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, startX, startY, endX, endY, visited);
    }

    private boolean dfs(int[][] maze, int x, int y, int endX, int endY, boolean[][] visited) {
        if (x == endX && y == endY) {
            return true;
        }

        visited[x][y] = true;
        
        for (int[] dir : DIRECTIONS) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (isValidMove(maze, newX, newY) && !visited[newX][newY]) {
                if (dfs(maze, newX, newY, endX, endY, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValidMove(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }

    public static void main(String[] args) {
        
        System.out.println("Enter rows");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m];

        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        
        MazeSolver solver = new MazeSolver();

        System.out.println("Enter starting coords");


        int sx = sc.nextInt();
        int sy = sc.nextInt();
        
        System.out.println("ENter ending coords");
        
        int ex = sc.nextInt();
        int ey = sc.nextInt();
        boolean isSolvable = solver.solveMaze(arr, sx, sy, ex, y);

        if (isSolvable) {
            System.out.println("The maze is solvable!");
        } else {
            System.out.println("No path found in the maze.");
        }
    }
}