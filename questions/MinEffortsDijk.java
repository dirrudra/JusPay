package questions;
import java.util.*;

public class MinEffortsDijk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("m=3");
        int m = 3;
        int arr[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int src = scanner.nextInt();
        int dest = scanner.nextInt();


        int ans = minEffortsRequired(arr, src, dest);
        System.out.println(ans);
    }

    public static int minEffortsRequired(int[][] arr, int src, int dest) {
        int n = arr.length;
        int m =3;
        int cost = 0;

        int source = src;

        int temp[][] = arr;




        return cost;

    }

    
}
