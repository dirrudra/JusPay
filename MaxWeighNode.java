import java.util.*;

public class MaxWeighNode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if (nums[i] != -1) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + i);
            }
        }

        int max = Integer.MIN_VALUE;
        int res = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }

        System.out.println(res);
    }
}
