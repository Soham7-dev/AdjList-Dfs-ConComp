import java.util.*;
import java.lang.*;

public class BellmanFord{

    static Scanner sc = new Scanner(System.in);
    
    static int v = sc.nextInt(), e = sc.nextInt();

    static final int INF = (int)1e9;

    static int[][] adj = new int[v+1][v+1];

    static int[] dist = new int[v+1];

    public static void main(String args[]){

        for(int i = 0; i < e; i++){
            int x = sc.nextInt(), y = sc.nextInt(), w = sc.nextInt();
            adj[x][y] = w;
            adj[y][x] = w;
        }

        Arrays.fill(dist, INF);

        dist[1] = 0;

        for(int itr = 1; itr < v; itr++){

            for(int i = 0; i < v+1; i++){
                for(int j = 0; j < v+1; j++){
                    if(adj[i][j] != 0){
                        int u = i;
                        int v = j;
                        int w = adj[i][j];
                        dist[v] = Math.min(dist[v], dist[u] + w);
                    }
                }
            }
        }

        for(int i = 1; i < v+1; i++){
            System.out.print(dist[i] + " ");
        }
    }
}