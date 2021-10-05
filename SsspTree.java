import java.util.*;
import java.lang.*;
//This is the Tree
//      1
//     /
//    2 
//   / \     
//  3   4
//     / \
//    5   6

public class SsspTree{

    static int v = 6;

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

    static int[] vis = new int[v+1];

    static int[] dis = new int[v+1];

    public static void main(String[] args){
        
        for(int i = 0; i < v+1; i++){
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,4,5);
        addEdge(adj,4,6);

        dfs(1,0);

        System.out.println(Arrays.toString(dis));
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> a, int v, int u){
        a.get(v).add(u);
        a.get(u).add(v);
    }

    public static void dfs(int v, int d){
        vis[v] = 1;

        for(int child : adj.get(v)){
            if(vis[child] == 0){
                dis[child] = dis[v] + 1;
                dfs(child, dis[child]);
            }
        }
    }
}