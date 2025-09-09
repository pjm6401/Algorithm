import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] graph = new int[1001][1001];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = w;
        }
        int [] dist = new int [n+1];

        for(int i = 1; i<=n; i++){
            dist[i] = 10001;
        }
        dist[1] = 0;
        boolean [] visit = new boolean [n+1];
        for(int i = 1; i<=n; i++){
            int minIdx = -1;
            for(int j = 1; j<=n; j++){
                if(visit[j]) continue;

                if(minIdx ==-1 || dist[minIdx]>dist[j]){
                    minIdx = j;
                }
            }
            
            visit[minIdx] = true;

            for(int j=1; j<=n; j++){
                if(graph[minIdx][j] == 0)
                    continue;

                dist[j] = Math.min(dist[j],dist[minIdx]+graph[minIdx][j]);
            }
        }
        for(int i = 2; i<=n; i++){
            System.out.println(dist[i]);
        }
    }
}