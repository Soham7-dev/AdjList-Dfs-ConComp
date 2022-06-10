import java.util.*;
import java.lang.*;
//This is the Graph
//      1
//     /
//    2 
//   / \     
//  3---4
//     / \
//    5   6

public class findCycle{

    //Number of Vertex
    static int v = 6;

    //Declaring Adj List
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

    //Visited Array
    static int[] vis = new int[v+1];

    public static void main(String args[]){

        for(int i = 0; i < v+1; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        //Addding Edge
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        addEdge(adj,4,6);

        if(dfs(1,-1))
            System.out.println("\nA Cycle is Found!\n");
        else
            System.out.println("\nNo Cycles Found\n");
            
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> a, int v, int u){
        a.get(v).add(u);
        a.get(u).add(v);
    }

    public static boolean dfs(int v, int parent){
        vis[v] = 1;

        for(int i : adj.get(v)){
            if(vis[i] == 0){
                if(dfs(i,v) == true)
                    return true;
            }
            else if(i != parent) //If i is already visited then it has to be a parent of the current vertex otherwise there is a cycle
                return true;
        }
        return false;
    }
}