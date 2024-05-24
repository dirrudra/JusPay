package questions;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class JusPayLockingSpacePartA {
    class TestClass {
        
        static class Node{
            String str;
            boolean isLocked;
            int id;
            Node anc;
            List<Node> children;
            int desc;
            List<Node> descLock;

            Node(String str){
                this.str = str;
                this.isLocked = false;
                this.id = 0;
                this.children = new ArrayList<>();
                this.desc = 0;
                this.descLock = new ArrayList<>();
            }
        }

        public static void main(String args[] ) throws Exception {
            Scanner sc = new Scanner(System.in);

            int nodes = sc.nextInt();
            int kids = sc.nextInt();
            int qs = sc.nextInt();
            sc.nextLine();

            String[] nodNames = new String[nodes];

            for(int a =0;a<nodes;a++){
                nodNames[a] = sc.nextLine();
            }
            Node root = treeBuilder(nodNames, kids);
            Map<String, Node> nodemap = new HashMap<>();
            nodePopper(root,nodemap);

            for(int i=0 ;i<qs ; i++){
                String quer = sc.nextLine();
                String[] qparts = quer.split(" ");
                int op = Integer.parseInt(qparts[0]);
                String nameNode = qparts[1];
                int uid = Integer.parseInt(qparts[2]);

                Node node = nodemap.getOrDefault(nameNode,null);
                boolean result = false;
                
                if(op == 1){
                    result = lock(node, uid);
                }else if(op == 2){
                    result = unlock(node,uid);
                }else if(op ==3){
                    result = upgrade(node,uid);
                }else{
                    result = false;
                }
                System.out.println(result);
            }
            sc.close();
        }

        public static boolean lock(Node node, int uid){
            if(node == null){
                return false;
            }
            if(node.isLocked || node.desc > 0){
                return false;
            }

            Node anc = node.anc;
            while(anc != null){
                if(anc.isLocked){
                    return false;
                }
                anc = anc.anc;
            }
            descUpdate(node,1,node);
            node.isLocked = true;
            node.id = uid;
            return true;
        }

        public static boolean unlock(Node node, int uid){
            if(node == null){
                return false;
            }
            if(!node.isLocked || node.id != uid){
                return false;
            }
            descUpdate(node, -1, node);
            node.isLocked = false;
            node.id = 0;
            return true;
        }

        public static boolean upgrade(Node node, int uid){
            if(node == null) return false;
            if(node.desc == 0 || node.isLocked) return false;

            List<Node> ab = node.descLock;

            for(Node i:ab){
                if(i.isLocked && i.id != uid) return false;
            }

            int l = ab.size();
            Node parent = node.anc;
            while(parent != null){
                parent.desc -= l;
                parent.descLock.removeAll(ab);
                parent.descLock.add(node);
                parent = parent.anc;
            }
            
            for(Node i:ab){
                i.isLocked = false;
                i.id = 0;
                Node par = i.anc;
                while(par!= node){
                    par.desc -=1;
                    par.descLock.remove(i);
                    par = par.anc;
                }
            }
            node.desc = 0;
            node.descLock.clear();
            node.isLocked = true;
            node.id=uid;
            return true;
            
            // }
            // for(Node dnode : node.descLock){
            //     if(dnode.isLocked && dnode.id != uid){
            //         return false;
            //     }
            // }
            // List<Node> desc = new ArrayList<>(node.descLock);
            // for(Node dnode : desc){
            //     unlock(dnode, dnode.id);
            // }
            // node.isLocked = true;
            // node.id = uid;
            // return true;
        }

        private static void descUpdate(Node node, int del, Node desc){
            Node par = node.anc;
            while(par != null){
                par.desc += del;
                if(del > 0){
                    par.descLock.add(desc);
                }else{
                    par.descLock.remove(desc);
                }
                par = par.anc;
            }
        }

        private static void nodePopper(Node root, Map<String,Node> nodemap){
            if(root == null) return;
            nodemap.put(root.str, root);
            for(Node kid : root.children){
                nodePopper(kid, nodemap);
            }
        }
        private static Node treeBuilder(String[] nodes, int m){
            if(nodes.length ==0){
                return null;
            }
            Node root = new Node(nodes[0]);
            Map<String,Node> nodemap = new HashMap<>();

            nodemap.put(nodes[0],root);
            Queue<Node> que = new LinkedList<>();
            que.add(root);
            int index = 1;

            while(!que.isEmpty() && index <nodes.length){
                Node par = que.poll();
                for(int i=0;i<m && index < nodes.length;i++){
                    Node kid = new Node(nodes[index++]);
                    par.children.add(kid);
                    kid.anc = par;
                    que.add(kid);
                }
            }
            return root;
        }
    }

}
