import java.util.Scanner;
public class Main {
    static int n;
    public static int vertexCnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int[] u = new int[m];
        int[] v = new int[m];
        int [][] grid = new int[n+1][n+1];
        boolean [] visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
            grid[u[i]][v[i]] = 1;
            grid[v[i]][u[i]] = 1;
        }
        DFS(1,grid,visited);
        if(vertexCnt !=0 ) vertexCnt-=1;
        System.out.println(vertexCnt);
    }

    public static void DFS (int v, int [][]grid,boolean [] visited) {
        for(int i = 1; i<=n; i++){
            if(grid[v][i] == 1 && !visited[i]){
                visited[i] = true;
                vertexCnt++;
                DFS(i,grid,visited);
            }
        }
    }
}