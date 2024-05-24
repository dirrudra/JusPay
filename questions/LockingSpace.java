package questions;
import java.util.*;


public class LockingSpace {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int qs = sc.nextInt();
        List<String> nodes = new ArrayList<>();
        System.out.println("nodes");
        nodes.add(sc.nextLine());
        for(int i = 0;i<n;i++){
            String temp = sc.nextLine();
            // System.out.println(i);
            nodes.add(temp);
        }
        System.out.println(nodes.size());
        List<String> queries = new ArrayList<>();
        System.out.println("queries");
        for(int i=0;i<qs;i++){
            queries.add(sc.nextLine());
        }
        Map<String, String> stats = precompute(nodes,queries,m);
        
        List<String> d = new ArrayList<>();
        for(String q : queries){
            String parts[] = q.split(" ");
            d.add(parts[1]);
            d.add(parts[0]);
        }
        for(int j=0;j<d.size() -1;j+=m){
            System.out.print(
                oper(
                    d.get(j),Integer.parseInt(d.get(j+1)),stats, nodes)+" "
                );
            }

    }



    static String oper(
        String name,
        int code,
        Map<String,String> stats,
        List<String> nodes
    ){
        String res = "false";
        switch(code){
            case 1:
            res = lock(name, stats);
            break;

            case 2:
            res = unlock(name,stats);
            break;

            case 3:
            res = upgrade(name,stats, nodes);
            break;
        }
        return res;
    }




    static Map<String, String> precompute(List<String> nodes, List<String> queries,int m){
        List<String> d = new ArrayList<>();
        for(String q : queries){
            String parts[] = q.split(" ");
            d.add(parts[1]);
            d.add(parts[0]);
        }
        Map<String, String> stats = new HashMap<>();
        for(int j=0;j<d.size() -1;j+=m){
            stats.put(d.get(j),"unlock");
        }
        return stats;
    }




    public static String lock(String name, Map<String, String> stats){
        if("lock".equals(stats.get(name))
        || "fail".equals(stats.get(name))){
            return "false";
        }else{
            stats.put(name,"lock");
            return "true";
        }

    }




    public static String unlock(String name, Map<String, String> stats){
        if("lock".equals(stats.get(name))){
            stats.put(name, "unlock");
            return "true";
        }else{return "false";}
    }
    



    public static String upgrade(String name, Map<String, String> stats, List<String> nodes){
        int ind = nodes.indexOf(name)+1;
        int c1 = ind * 2;
        int c2 = ind * 2 + 1;
        if(c1<nodes.size() && c2<nodes.size()){
            if("lock".equals(stats.get(nodes.get(c1-1)))
            && "lock".equals(stats.get(nodes.get(c2-1)))){
                stats.put(nodes.get(c1-1),"unlock");
                stats.put(nodes.get(c2-1),"unlock");
                stats.put(nodes.get(ind),"lock");
                return "true";
            }else{
                return "false";
            }
        }else{
            return "false";
        }
    }

}

