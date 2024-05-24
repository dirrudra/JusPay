package questions;
public class MazeNinja {
    public boolean pathExists(int[][] matrix, int sx, int sy, int dx, int dy) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ||
            sx < 0 || sx >= matrix.length || sy < 0 || sy >= matrix[0].length ||
            dx < 0 || dx >= matrix.length || dy < 0 || dy >= matrix[0].length ||
            matrix[sx][sy] == 1 || matrix[dx][dy] == 1) {
            return false;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        return dfsRightDown(matrix, sx, sy, dx, dy, visited) || dfsDownRight(matrix, sx, sy, dx, dy, visited);
    
    }

    private boolean dfsRightDown(int[][] matrix, int x, int y, int dx, int dy, boolean[][] visited) {
        if (x == dx && y == dy) return true;
        visited[x][y] = true;
        
        if (x + 1 < matrix.length && matrix[x + 1][y] == 0 && !visited[x + 1][y]) {
            if (dfsRightDown(matrix, x + 1, y, dx, dy, visited)) return true;
        }
        
        if (y + 1 < matrix[0].length && matrix[x][y + 1] == 0 && !visited[x][y + 1]) {
            if (dfsRightDown(matrix, x, y + 1, dx, dy, visited)) return true;
        }

        visited[x][y] = false;
        return false;
    }

    private boolean dfsDownRight(int[][] matrix, int x, int y, int dx, int dy, boolean[][] visited) {
        if (x == dx && y == dy) return true;
        visited[x][y] = true;

        if (y + 1 < matrix[0].length && matrix[x][y + 1] == 0 && !visited[x][y + 1]) {
            if (dfsDownRight(matrix, x, y + 1, dx, dy, visited)) return true;
        }
        
        if (x + 1 < matrix.length && matrix[x + 1][y] == 0 && !visited[x + 1][y]) {
            if (dfsDownRight(matrix, x + 1, y, dx, dy, visited)) return true;
        }
        visited[x][y] = false;
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 0, 0}
        };
        MazeNinja pathFinder = new MazeNinja();
        System.out.println("Path exists? " + pathFinder.pathExists(matrix, 0, 0, 3, 3));
    }
}
