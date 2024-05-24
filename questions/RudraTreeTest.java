package questions;
import java.util.*;

class RudraTreeTest{
    static class Node{
        String str;
        boolean isLocked;
        int id;
        Node parent;
        List<Node> children;
        int dCount;
        List <Node> dLockList;
        Node(String s){
            this.str = s;
            this.isLocked = false;
            this.id = 0;
            this.children = new ArrayList<>();
            this.dCount = 0;
            this.dLockList = new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int qs = sc.nextInt();

        System.out.println("Enter nodes");
        

    }
}