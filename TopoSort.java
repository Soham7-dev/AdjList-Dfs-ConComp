import java.util.*;
import java.lang.*;

public class TopoSort{

    static Scanner sc = new Scanner(System.in);

    static int v = sc.nextInt(), e = sc.nextInt();

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v+1);

    static Queue<Integer> queue = new LinkedList<Integer>();

    static int[] indeg = new int[v+1];

    public static void main(String args[]){

        for(int i = 0; i <= v; i++){

            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < e; i++){
            
            int x = sc.nextInt(), y = sc.nextInt();

            addEdge(adj, x, y);
        }

        toposort();
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> a, int v, int u){

        a.get(v).add(u);

        indeg[u]++;
    }

    public static void toposort(){

        for(int i = 1; i <= v; i++){
            if(indeg[i] == 0){
                queue.add(i);
            }
        }

        while(queue.size() != 0){

            int q = queue.poll();

            System.out.print(q + " ");

            for(int i : adj.get(q)){
                indeg[i]--;
                if(indeg[i] == 0){
                    queue.add(i);
                }
            }
        }
    }
}