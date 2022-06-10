import java.util.*;
import java.lang.*;
//This is the Graph
//      1
//     /
//    2 --- 5
//   / \     \
//  3   4 --- 6

public class Dfs{
    
    //Number of Vertices
    static int v = 6;

    //Declaring Adjacency List
    static ArrayList<ArrayList<Integer>> li = new ArrayList<ArrayList<Integer>>(v+1);

    //Array to Check if node is visited or not
    static int[] vis = new int[v+1];

    public static void main(String args[]){

        for(int i = 0; i <= v; i++){
            li.add(new ArrayList<Integer>());
        }

        //Number of Edges
        addEdge(li, 1, 2);
        addEdge(li, 2, 3);
        addEdge(li, 2, 4);
        addEdge(li, 2, 5);
        addEdge(li, 5, 6);
        addEdge(li, 4, 6);

        //Call the dfs function and initiate the recursion
        dfs(1);
        
        //After the recursion completes we print the vis Array
        System.out.println("\n" + Arrays.toString(vis));
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> a, int v, int u){
        a.get(v).add(u);
        a.get(u).add(v);
    }

    public static void dfs(int v){

        //Make the Vertex v Visited and Print it
        vis[v] = 1;
        System.out.print(v + " ");

        for(int i : li.get(v)){
            if(vis[i] == 0){
                dfs(i);
            }
        }
    }
}