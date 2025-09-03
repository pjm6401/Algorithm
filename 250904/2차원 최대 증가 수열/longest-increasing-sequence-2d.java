import java.util.Scanner;
public class Main {

    public static int [][] grid;
    public static int [][] dp;
    public static int m;
    public static int n;
    public static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        dp = new int [n][m];
        dp[0][0] = 1; 
        dfs(0,0);
        System.out.println(ans);
    }

    public static void dfs(int x, int y){
        if(x == n-1 || y == m-1){
            for(int i = 1; i<n; i++){
                for(int j = 1; j<m; j++){
                    ans = Math.max(dp[i][j],ans);
                }
            }
            return;
        }

        for(int i = x+1; i<n; i++){
            for(int j = y+1; j<m; j++){
                if(grid[i][j]>grid[x][y]){
                    dp[i][j] = Math.max(dp[i][j], dp[x][y]+1);
                    dfs(i,j);
                }
            }
        }

        
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y<m && y>=0);
    }
}