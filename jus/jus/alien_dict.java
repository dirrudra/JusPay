import java.util.*;


public class Main {
	
	
static class Solve  {
  private List<Integer> topoSort(int V, List<List<Integer>> adj) {
    int indegree[] = new int[V];
    for (int i = 0; i < V; i++) {
      for (int it : adj.get(i)) {
        indegree[it]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }
    List<Integer> topo = new ArrayList<>();
    while (!q.isEmpty()) {
      int node = q.peek();
      q.remove();
      topo.add(node);

      for (int it : adj.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) q.add(it);
      }
    }

    return topo;
  }

  public String findOrder(String[] dict, int N, int K) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < K; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      String s1 = dict[i];
      String s2 = dict[i + 1];
      int len = Math.min(s1.length(), s2.length());
      for (int ptr = 0; ptr < len; ptr++) {
        if (s1.charAt(ptr) != s2.charAt(ptr)) {
          adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
          break;
        }
      }
    }

    List<Integer> topo = topoSort(K, adj);
    String ans = "";
    for (int it : topo) {
      ans = ans + (char) (it + (int) ('a'));
    }

    return ans;
  }
}
  public static void main(String[] args) {
    Scanner sc  = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    
    String[] dict = new String[n];
    
    for(int i=0;i<n;i++){
    	dict[i] = sc.next();
    }
    Solve obj = new Solve();
    String ans = obj.findOrder(dict, n, k);

    for (int i = 0; i < ans.length(); i++) {
      System.out.print(ans.charAt(i) + " ");
    }
    System.out.println("");
  }
}
