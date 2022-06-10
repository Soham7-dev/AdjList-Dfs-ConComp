import java.util.*;
import java.lang.*;

public class kruskalDSU{

    static Scanner sc = new Scanner(System.in);

    static int v = sc.nextInt(), e = sc.nextInt();

    static int[][] edges = new int[e][3];

    static int[] parent = new int[100000];

    static int[] size = new int[100000];

    public static void main(String args[]){
        for(int i = 0; i <= v; i++){
            make_set(i);
        }

        for(int i = 0; i < e; i++){
            int x = sc.nextInt(), y = sc.nextInt(), w = sc.nextInt();
            
            edges[i][0] = x;
            edges[i][1] = y;
            edges[i][2] = w;
        }

        Arrays.sort(edges, (a,b) -> a[2]-b[2]);

        int cost = 0;

        for(int[] i : edges){
            int u = i[0];
            int v = i[1];
            int w = i[2];

            int p = find_set(u);
            int q = find_set(v);

            if(p == q){
                continue;
            }
            else{
                System.out.println(u + " " + v);
                cost += w;
                union_set(u, v);
            }
        }

        System.out.println(cost);
    }

    public static void make_set(int v){
        parent[v] = v;
        size[v] = 1;
    }

    public static int find_set(int v){
        if(parent[v] == v)
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