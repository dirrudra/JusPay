package questions;

import java.util.*;

public class MaxWeighNodeTests {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        int nums[] = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
            if(nums[i] != -1){
                map.put(nums[i],map.getOrDefault(nums[i], 0)+i);
            }
        }
        int max = Integer.MIN_VALUE;
        int res = 0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(max < entry.getValue()){
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        System.out.println(res);
        sc.close();

    }
}
