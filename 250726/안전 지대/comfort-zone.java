import java.util.Scanner;
public class Main {

    static int n;
    static int m;
    static int[][] grid = new int[50][50];
    static boolean [][] visit = new boolean[50][50];
    static int maxK = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int safe = -1;
                
        for(int k = 1; k <= 100; k++){
            int safeTemp = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(grid[i][j]>k && !visit[i][j]){
                        DFS(i,j,k);
                        safeTemp++;
                    }
                }
            }
            visit = new boolean[n][m];
            if(safeTemp > safe){
                safe = safeTemp;
                maxK = k;
            }
        }        
        System.out.println(maxK + " "+ safe);
            
    }

    public static void DFS(int x, int y,int k){
        if(!visit[x][y] && grid[x][y]>k){
            visit[x][y] = true;
            if(isRange(x+1,y)) DFS(x+1,y,k);
            if(isRange(x-1,y)) DFS(x-1,y,k);
            if(isRange(x,y+1)) DFS(x,y+1,k);
            if(isRange(x,y-1)) DFS(x,y-1,k);
        }
    }

    public static boolean isRange(int x, int y){
        return(x>=0 && x<n && y>=0 && y<m);
    }
}