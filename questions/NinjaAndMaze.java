package questions;
import java.util.*;

class NinjaAndMaze {

    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int n = sc.nextInt();
        System.out.println("Enter the number of columns:");
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        System.out.println("Enter the maze matrix (0 for open path, 1 for obstacle):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean[][] vis = new boolean[n][m];

        System.out.println("Enter starting coordinates (sx sy):");
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        System.out.println("Enter destination coordinates (dx dy):");
        int dx = sc.nextInt();
        int dy = sc.nextInt();

        // Check if start or end coordinates are invalid
        if (!isValid(arr, sx, sy, vis) || !isValid(arr, dx, dy, vis)) {
            System.out.println("Invalid start or destination coordinates.");
            return;
        }

        boolean found = dfs(arr, vis, sx, sy, dx, dy, -1);

        if (found) {
            System.out.println("Path found from start to destination.");
        } else {
            System.out.println("No path exists from start to destination.");
        }
    }

    private static boolean dfs(int[][] grid, boolean[][] visited, int x, int y, int dx, int dy, int dir) {
        // Base case: if we reached the destination
        if (x == dx && y == dy) {
            return true;
        }

        // Mark the current cell as visited
        visited[x][y] = true;
        System.out.println("Visited cell: (" + x + ", " + y + ")");

        // Try to continue in the current direction if it is set
        if (dir != -1) {
            int newX = x + rowDir[dir];
            int newY = y + colDir[dir];
            if (isValid(grid, newX, newY, visited)) {
                if (dfs(grid, visited, newX, newY, dx, dy, dir)) {
                    return true;
                }
            }
        }

        // Try other directions
        for (int i = 0; i < 4; i++) {
            int newX = x + rowDir[i];
            int newY = y + colDir[i];
            if (isValid(grid, newX, newY, visited)) {
                if (dfs(grid, visited, newX, newY, dx, dy, i)) {
                    return true;
                }
            }
        }

        // Unmark the current cell as visited for other possible paths (if any)
        visited[x][y] = false;
        return false;
    }

    private static boolean isValid(int[][] grid, int x, int y, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        return x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0 && !visited[x][y];
    }
}




// import java.util.*;



// class NinjaAndMaze{

//     private static final int[] rowDir = {-1, 1, 0, 0};
//     private static final int[] colDir = {0, 0, -1, 1};

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number of rows");
//         int n = sc.nextInt();
//         System.out.println("Enter the number of columns");
//         int m = sc.nextInt();
        
//         int arr[][] = new int[n][m];

//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 arr[i][j] = sc.nextInt();
//             }
//         }

//         boolean vis[][] = new boolean[n][m];
        
//         System.out.println("enter starting coordinates");
//         int sx = sc.nextInt();
//         int sy = sc.nextInt();
//         System.out.println("Enter destination coordinates");
//         int dx = sc.nextInt();
//         int dy = sc.nextInt();

//         boolean flag = dfs(arr,vis,sx,sy,dx,dy);
        


//     }







//     private static void dfs(int[][] grid, boolean[][] visited,int sx,int sy, int dx, int dy) {
//         if (!isValid(grid, x, y, visited)) return;

//         // Mark the current cell as visited
//         visited[x][y] = true;
//         System.out.println("Visited cell: (" + x + ", " + y + ")");

//         // Explore the neighbors
//         for (int i = 0; i < 4; i++) {
//             int newX = x + rowDir[i];
//             int newY = y + colDir[i];
//             dfs(grid, visited);
//         }
//     }

//     private static boolean isValid(int[][] grid, int x, int y, boolean[][] visited) {
//         int n = grid.length;
//         int m = grid[0].length;
//         return x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0 && !visited[x][y];
//     }
// }






// import java.util.*;
// class NinjaAndMaze{
//     static int directions[][] = { {0,1},{1,0},{0,-1},{-1,0} };
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number of rows");
//         int n = sc.nextInt();
//         System.out.println("Enter the number of columns");
//         int m = sc.nextInt();

//         int arr[][] = new int[n][m];

//         for(int i = 0;i<n;i++){
//             for(int j = 0;j<m;j++){
//                 arr[i][j] = sc.nextInt();
//             }
//         }

//         boolean vis[][] = new boolean[n][m];
        
//         int sx = sc.nextInt();
//         int sy = sc.nextInt();
//         int dx = sc.nextInt();
//         int dy = sc.nextInt();


//         boolean flag = dfs(arr,vis,sx,sy,dx,dy);
//         System.out.println(flag);
//     }



//     public static boolean dfs(int arr[][],boolean vis[][],int sx,int sy,int dx,int dy){
//         // if (
//         //     sx < 0 || sx >= arr.length || sy < 0 || sy >= arr[0].length ||
//         //     arr[sx][sy] == 1 || vis[sx][sy]
//         // ){
//         //     return false;
//         // }
//         // else{
//             vis[sx][sy] = true;
//             for(int i=0;i<4;i++){
//                 int x = sx+directions[i][0];
//                 int y = sy+directions[i][1];
                
//                 while(0<=x && x<arr.length && 0<=y && y<arr.length && arr[x][y]==0){
//                     x+=directions[i][0];
//                     y+=directions[i][1];
//                 }
//                 x-=directions[i][0];
//                 y-=directions[i][1];

//                 if(dfs(arr, vis, x, y, dx, dy)){
//                     return true;
//                 }
//             }
//             return false;
//         // }
//     }

// }
