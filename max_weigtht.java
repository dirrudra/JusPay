import java.util.*;

class Main {

	public static int maxCell(int n, ArrayList<Integer> arr)
	{
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			if (arr.get(i) != -1) {
				temp[arr.get(i)] += i;
			}
		}
		int ans = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (temp[i] > max) {
				ans = i;
				max = temp[i];
			}
		}
		return ans;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--!=0){
	        int n = sc.nextInt();
	        ArrayList<Integer> arr = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            arr.add(sc.nextInt());
	        }
	       
	        System.out.println(maxCell(n,arr));
	}
}
}
