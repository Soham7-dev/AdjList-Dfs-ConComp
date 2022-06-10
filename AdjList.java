import java.util.*;
import java.lang.*;
//This is the Graph
//      1
//     /
//    2 --- 5
//   / \     \
//  3   4 --- 6

public class AdjList{

    public static void main(String args[]){
        //Number of Vertices
        int v = 6;

        //Declaring Adjacency List
        ArrayList<ArrayList<Integer>> li = new ArrayList<ArrayList<Integer>>(v+1);

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

        //Printing the Adjacency List
        for(int i = 1; i <= v; i++){

            System.out.print(i + " : ");

            for(int j : li.get(i)) System.out.print(" -> " + j);

            System.out.println();
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> a, int v, int u){
        a.get(v).add(u);
        a.get(u).add(v);
    }
}