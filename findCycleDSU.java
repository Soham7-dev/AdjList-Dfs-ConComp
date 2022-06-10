import java.util.*;
import java.lang.*;

public class findCycleDSU{

    static Scanner sc = new Scanner(System.in);

    static int v = sc.nextInt(), e = sc.nextInt();

    //Adjancency List isn't necessary for this program
    // static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v+1);

    static int[][] edges = new int[e][2];

    static int[] parent = new int[100000];

    static int[] size = new int[100000];

    public static void main(String args[]){

        for(int i = 0; i <= v; i++){
            make_set(i);
        }

        for(int i = 0; i < e; i++){
            int x = sc.nextInt(), y = sc.nextInt();

            edges[i][0] = x;
            edges[i][1] = y;
        }

        boolean cycle = false;

        for(int[] i : edges){
            int u = i[0];
            int v = i[1];

            int x = find_set(u);
            int y = find_set(v);

            if(x == y){
                cycle = true;
            }
            else{
                union_set(u, v);
            }
        }

        if(cycle)
            System.out.println("Cycle found!");
        else
            System.out.println("No Cycles found");
    }

    //addEdge function isn't needed for this program rather we make a 2D array for storing edges
    // public static void addEdge(ArrayList<ArrayList<Integer>> a, int v, int u){
    //     a.get(v).add(u);
    //     a.get(u).add(v);
    // }

    public static void make_set(int v){
        parent[v] = v;
        size[v] = 1;
    }

    public static int find_set(int v){
        if(v == parent[v])
            return v;
        return parent[v] = find_set(parent[v]);
    }

    public static void union_set(int a, int b){
        a = find_set(a);
        b = find_set(b);
        if(a != b){
            if(size[a] < size[b])
                swap(a, b);
            parent[b] = a;
            size[a] += size[b]; 
        }
    }

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
}