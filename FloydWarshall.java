import java.util.*;
import java.lang.*;

public class FloydWarshall{

    public static void main(String args[]){

        final int INF = (int)1e9;

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt(), e = sc.nextInt();

        int[][] adj = new int[v+1][v+1];

        for(int i = 1; i < v+1; i++){
            for(int j = 1; j < v+1; j++){
                if(i != j)
                    adj[i][j] = INF;
            }
        }

        for(int i = 0; i < e; i++){
            int x = sc.nextInt(), y = sc.nextInt(), w = sc.nextInt();
            adj[x][y] = w;
            adj[y][x] = w;
        }

        int[][] dis = adj;

        for(int k = 1; k < v+1; k++){
            for(int i = 1; i < v+1; i++){
                for(int j = 1; j < v+1; j++){
                    if(dis[i][k] + dis[k][j] < dis[i][j]){
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        for(int i = 1; i < v+1; i++){
            for(int j = 1; j < v+1; j++){
                if(dis[i][j] == INF){
                    System.out.print("Inf. ");
                }
                else{
                    System.out.print(dis[i][j] + " ");
                }
            }

            System.out.println();
        }
    }
}