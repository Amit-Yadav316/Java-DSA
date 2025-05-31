package Tree;

import java.util.*;

public class Node {
    int data ;
    ArrayList<Node> children ;
    Node() {
        children = new ArrayList<>() ;
        }
    Node(int data) {
        this.data = data ;
        children = new ArrayList<>() ;
        }
}

class solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>() ;
        Queue<Node> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while(!queue.isEmpty()) {
            int size = queue.size() ;
            ArrayList<Integer> list = new ArrayList<>() ;
            while(size>0) {
            Node node = queue.poll() ;
            list.add(node.data) ;
            for(Node c : node.children) {
                if(c != null) {
                queue.offer(c) ;
                }
            }
            size-- ;
            }
            ans.add(list) ;
        }
        return ans ;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node();
        root.data = 1;
        Node child1 = new Node();
        child1.data = 2;
        Node child2 = new Node();
        child2.data = 3;
        root.children.add(child1);
        root.children.add(child2);
        
        solution sol = new solution();
        List<List<Integer>> result = sol.levelOrder(root);
        
        System.out.println(result); 
    }
}
