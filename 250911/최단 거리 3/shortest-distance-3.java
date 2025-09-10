import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] graph = new int [n+1][n+1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = w;
            graph[v][u] = w;
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean [] visit = new boolean [n+1];
        int [] dist = new int [n+1];
        // 2147483647
        // 100000000
        for(int i = 1; i<=n; i++){
            dist[i] =  100000001;
        }
        dist[a] = 0;
        dist[0] = 0;
        for(int i = 1; i<=n; i++){
            int minIdx = -1;

            for(int j=1; j<=n; j++){
                if(visit[j]) continue;

                if(minIdx == -1 || dist[minIdx]>dist[j]){
                    minIdx = j;
                }
            }

            visit[minIdx] = true;

            for(int j = 1; j<=n; j++){
                if(graph[minIdx][j] != 0) dist[j] = Math.min(dist[j] , dist[minIdx]+graph[minIdx][j]);
                if(graph[j][minIdx] != 0) dist[j] = Math.min(dist[j] , dist[minIdx]+graph[j][minIdx]);
            }
        }

        System.out.println(dist[b]);
    }
}