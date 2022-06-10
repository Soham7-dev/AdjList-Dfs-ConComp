import java.util.*;
import java.lang.*;

//WHILE IMPLEMENTING DIJKSTRA CONSIDER USING ADJACENCY MATRIX INSTEAD OF ADJANCENCY LIST
public class Dijkstra{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt(), e = sc.nextInt();

        int[][] adj = new int[v+1][v+1];
        
        for(int i = 0; i < e; i++){
            int v1 = sc.nextInt(), v2 = sc.nextInt(), w = sc.nextInt();
            adj[v1][v2] = w;
            adj[v2][v1] = w;
        }

        dijkstra(adj);
    }

    public static void dijkstra(int[][] adj){
        int v = adj.length;
        int[] vis = new int[v];
        int[] dis = new int[v];
        
        dis[1] = 0;

        for(int i = 2; i < v; i++){
            dis[i] = Integer.MAX_VALUE; 
        }

        for(int i = 1; i < v; i++){
            //Find Vertex with Minimum Distance
            int minVertex = findMinVertex(dis, vis);
            vis[minVertex] = 1;
            
            //Iterate neighbors
            for(int j = 1; j < v; j++){
                if(adj[minVertex][j] != 0 && vis[j] == 0 && dis[minVertex] != Integer.MAX_VALUE){
                    int newDist = dis[minVertex] + adj[minVertex][j];
                    if(newDist < dis[j])
                        dis[j] = newDist;
                }
            }
        }

        //Print
        for(int i = 1; i < v; i++){
            System.out.println(i + " " + dis[i]);
        }
    }

    public static int findMinVertex(int[] dis, int[] vis){
        
        int minVertex = -1;
        
        for(int i = 1; i < dis.length; i++){
            if(vis[i] == 0 && (minVertex == -1 || dis[i] < dis[minVertex])){
                minVertex = i;
            }
        }

        return minVertex;
    }
}