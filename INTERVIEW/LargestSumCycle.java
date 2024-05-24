package INTERVIEW;
import java.util.Scanner;

public class LargestSumCycle {
    public static int largestSumCycle(int[] edges) {
        int res = 0;
        int n = edges.length;
        
        for (int i = 0; i < n; i++) {
            int curr = edges[i];
            int sum = curr;
            int next = edges[curr];
            int k = 0;
            
            while (curr != next && k < n + 1) {
                if (next == -1 || curr == -1) {
                    sum = 0;
                    break;
                }
                if (next != curr) {
                    sum += next;
                }
                next = edges[next];
                k++;
            }
            
            if (sum > res && k != n + 1) {
                res = sum;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] edges = new int[n];
        
        for (int i = 0; i < n; i++) {
            edges[i] = scanner.nextInt();
        }
        
        System.out.println(largestSumCycle(edges));
    }
}
