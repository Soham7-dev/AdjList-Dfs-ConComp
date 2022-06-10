import java.util.*;
import java.lang.*;
//This is the Graph
//      1
//     /
//    2 --- 5
//   / \     \
//  3   4 --- 6


public class Bfs{

    static int v = 6;

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v+1);

    static int[] vis = new int[v+1];

    static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String args[]){

        for(int i = 0; i <= v; i++){
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 2, 5);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 6);
        addEdge(adj, 5, 6);

        Bfs(1);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> a, int v, int u){
        a.get(v).add(u);
        a.get(u).add(v);
    }

    public static void Bfs(int n){

        vis[n] = 1;
        queue.add(n);

        while(queue.size() != 0){
            n = queue.poll();

            System.out.print(n + " ");

            for(int i = 0; i < adj.get(n).size(); i++){
                
                int p = adj.get(n).get(i);

                if(vis[p] == 0){
                    vis[p] = 1;
                    queue.add(p);
                }
            }
        }
    }
}