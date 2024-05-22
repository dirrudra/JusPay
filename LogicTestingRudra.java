import java.util.*;

public class LogicTestingRudra {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i < 10; i++) {
            System.out.println(i+1);
        }
        List<String>nodes = new ArrayList<String>();
        int n = 7;
        for(int i = 0;i<n;i++){
            String temp = sc.nextLine();
            // System.out.println(i);
            nodes.add(temp);
        }
        
        sc.close();
    }
}
