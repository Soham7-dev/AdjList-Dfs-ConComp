import java.util.*;
import java.lang.*;
//This is the Graph
//         1
//       /   \
//     /      \
//    2        3
//    |        |
//    4        5
//    \       /
//     \    /
//       6

//  Basically if there is a cycle of ODD LENGTH present in the Graph then it is not Bipartite else it is Bipartite

public class CheckBigraph{

    static int v = 6;

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

    static int[] vis = new int[v+1];

    static int[] col = new int[v+1];

    public static void main(String args[]){
        
        for(int i = 0; i < v+1; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,2,4);
        addEdge(adj,3,5);
        addEdge(adj,4,6);
        addEdge(adj,5,6);

        if(dfs(1,0))
            System.out.println("\nGraph is Bipartite\n");
        else
            System.out.println("\nGraph is **NOT** Bipartite\n");
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> a, int v, int u){
        a.get(v).add(u);
        a.get(u).add(v);
    }

    public static boolean dfs(int v, int c){
        vis[v] = 1;
        col[v] = c;

        for(int child : adj.get(v)){
            if(vis[child] == 0){
                if(dfs(child, c^1) == false)
                    return false;
            }
            else{
                if(col[v] == col[child])
                    return false;
            }
        }

        return true;
    }
}