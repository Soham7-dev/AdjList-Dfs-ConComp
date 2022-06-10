import java.util.*;
import java.lang.*;

public class findCycleInDirectedGraph{

    static Scanner sc = new Scanner(System.in);

    static int v = sc.nextInt(), e = sc.nextInt();

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v+1);

    static int[] vis = new int[v+1];

    static int[] stack = new int[v+1];

    public static void main(String args[]){
        
        for(int i = 0; i <= v; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < e; i++){
            int x = sc.nextInt(), y = sc.nextInt();

            addEdge(adj, x, y);
        }

        if(isCycle(1))
            System.out.println("Cycle is Present!");
        else
            System.out.println("Cycle is not Present");
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> a, int v, int u){
        a.get(v).add(u);
    }

    public static boolean isCycle(int n){

        vis[n] = 1;

        stack[n] = 1;

        for(int i : adj.get(n)){
            if(vis[i] == 0){
                if(isCycle(i) == true)
                    return true;
            }
            else if(stack[i] == 1){
                return true;
            }
        }
        stack[n] = 0;
        return false;
    }
}