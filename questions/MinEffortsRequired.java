package questions;
import java.util.*;

public class MinEffortsRequired {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int src = sc.nextInt();
        int dest = sc.nextInt();

        int ans = minEffortsRequired(arr, src, dest);
        System.out.println(ans);
    }

    public static int minEffortsRequired(int[][] arr, int src, int dest) {
        
        int n = arr.length;
        int cost = 0;
        int source = src;
        int temp[][] = arr;
        
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });


        for (int i = 0; i < n; i++) {
            if (temp[i][0] == source) {
                
                int node = arr[i][1];
                int effort = arr[i][2];

                if (node == dest) {
                    cost += effort;
                    return cost;
                } else {
                    source = node;
                    cost += effort;
                    i = -1;
                }
            }
        }

        return -1;
    }
}



// import java.util.*;


// public class MinEffortsRequired {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         int arr[][] = new int[n][m];
//         for (int i = 0;i<n;i++){
//             for(int j = 0;j<m;j++){
//                 arr[i][j] = sc.nextInt();
//             }
            
//         }
//         int src = sc.nextInt();
//         int dest = sc.nextInt();

//         int ans = minEffortsRequired(arr,src,dest);
//         System.out.println(ans);

//     }
//     public static int minEffortsRequired(int[][] arr, int src, int dest){
//         int n = arr.length;
//         int m = arr[0].length;
//         int temp[][] = arr;
//         int source = src;
//         int desti = dest;
        
//         Arrays.sort(temp, new Comparator<int[]>() {
//             @Override
//             public int compare(int[] a, int[] b) {
//                 return Integer.compare(a[0], b[0]);
//             }
//         });
//         int cost = Integer.MAX_VALUE;
//         int node = 0;

//         // List<Integer> list = new ArrayList<Integer>();
//         for(int i=0;i<n;i++){
//             if (temp[i][0] == source){

//                 node = temp[i][1];
                
//                 if(node == desti){
//                     cost= Math.min(cost,temp[i][3]);
//                 }else{
//                     source = temp[i][1];
//                     cost= Math.min(cost,temp[i][3]);
//                 }
//             }
//         }
//         System.out.println(cost);
//         return cost;

//     }


//     }

