import java.util.Scanner;
public class Main {
    static int [] dist;
    static int [][] edges;
    static int n;
    static int a;
    static int b;
    static int c;
    static boolean [] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        edges = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int v = sc.nextInt();
   
            edges[x][y] = v;
            edges[y][x] = v;
            

            
        }

        dist = new int [n+1];
        visit = new boolean[n+1];
        
        System.out.println(calc());
    }

    public static void init (){
        for(int i = 1; i<=n; i++){
            dist[i] = 1000000001;
            visit[i] = false;
        }
    }

    public static int calc (){
        int ans = 0;
        for(int k = 1; k<=n; k++){
            if(k==a || k==b || k==c) continue;
            init ();
            dist[k] = 0;
            int min = -1;
            for(int i = 1; i<=n; i++){
                int minIdx = -1;

                for(int j = 1; j<=n; j++){
                    if(visit[j]) continue;

                    if(minIdx == -1 || dist[minIdx]>dist[j]){
                        minIdx = j;
                    }
                }

                visit[minIdx] = true;

                for(int j = 1; j<=n; j++){
                    if(edges[minIdx][j] == 0 ) continue;

                    dist[j] = Math.min(dist[j],dist[minIdx]+ edges[minIdx][j]);
                }
            }
            int d = Math.min(dist[a], Math.min(dist[b], dist[c]));
            if (d != 1000000001) { // 유효한 거리일 때만 갱신
                ans = Math.max(ans, d);
            }
        }
        return ans;
    }
}