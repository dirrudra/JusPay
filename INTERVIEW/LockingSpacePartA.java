package INTERVIEW;
import java.util.*;

public class LockingSpacePartA {

    static class Node {
        String str;
        boolean isLocked;
        int id;
        Node parent;
        List<Node> children;
        int desc;
        List<Node> descLoc;

        Node(String str) {
            this.str = str;
            this.isLocked = false;
            this.id = 0;
            this.children = new ArrayList<>();
            this.desc = 0;
            this.descLoc = new ArrayList<>();
        }
    }


    public static boolean lock(Node node, int id) {
        if (node.isLocked || node.desc > 0)
            return false;
        Node parent = node.parent;
        while (parent != null) {
            if (parent.isLocked)
                return false;
            parent = parent.parent;
        }
        updateDescendants(node, 1, node);
        node.isLocked = true;
        node.id = id;
        return true;
    }

    public static boolean unlock(Node node, int id) {
        if (!node.isLocked || node.id != id)
            return false;
        updateDescendants(node, -1, node);
        node.isLocked = false;
        node.id = 0;
        return true;
    }

    public static boolean upgrade(Node node, int id) {
        if (node.desc == 0 || node.isLocked)
            return false;
        for (Node descNode : node.descLoc) {
            if (descNode.isLocked && descNode.id != id)
                return false;
        }
        List<Node> descendants = new ArrayList<>(node.descLoc);
        for (Node descNode : descendants) {
            unlock(descNode, descNode.id);
        }
        node.isLocked = true;
        node.id = id;
        return true;
    }

    private static void updateDescendants(Node node, int delta, Node descendant) {
        Node parent = node.parent;
        while (parent != null) {
            parent.desc += delta;
            if (delta > 0) {
                parent.descLoc.add(descendant);
            } else {
                parent.descLoc.remove(descendant);
            }
            parent = parent.parent;
        }
    }

    private static Node buildTree(String[] nodeNames, int k) {
        if (nodeNames.length == 0)
            return null;
        Node root = new Node(nodeNames[0]);
        Map<String, Node> nodeMap = new HashMap<>();
        nodeMap.put(nodeNames[0], root);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty() && index < nodeNames.length) {
            Node parent = queue.poll();
            for (int i = 0; i < k && index < nodeNames.length; i++) {
                Node child = new Node(nodeNames[index++]);
                parent.children.add(child);
                child.parent = parent;
                nodeMap.put(child.str, child);
                queue.add(child);
            }
        }
        return root;
    }
    
    
    private static void populateNodeMap(Node node, Map<String, Node> nodeMap) {
        if (node == null)
            return;
        nodeMap.put(node.str, node);
        for (Node child : node.children) {
            populateNodeMap(child, nodeMap);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine(); 

        String[] nodeNames = new String[n];
        for (int i = 0; i < n; i++) {
            nodeNames[i] = sc.nextLine();
        }

        Node root = buildTree(nodeNames, k);
        Map<String, Node> nodeMap = new HashMap<>();
        populateNodeMap(root, nodeMap);

        for (int i = 0; i < q; i++) {
            int action = sc.nextInt();
            String nodeName = sc.next();
            int id = sc.nextInt();
            Node node = nodeMap.get(nodeName);
            boolean result = false;
            switch (action) {
                case 1:
                    result = lock(node, id);
                    break;
                case 2:
                    result = unlock(node, id);
                    break;
                case 3:
                    result = upgrade(node, id);
                    break;
            }
            System.out.println(result);
        }
        sc.close();
    }

}