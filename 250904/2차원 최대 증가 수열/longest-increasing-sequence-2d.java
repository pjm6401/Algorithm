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
        ans = 0;
        ans = Math.max(ans,dfs(0,0));
        
        System.out.println(ans);
    }

    public static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y]; // 이미 계산된 값이면 반환

        int maxLen = 1; // 자기 자신 포함
        for (int i = x + 1; i < n; i++) {
            for (int j = y + 1; j < m; j++) {
                if (grid[i][j] > grid[x][y]) {
                    maxLen = Math.max(maxLen, 1 + dfs(i, j));
                }
            }
        }
        dp[x][y] = maxLen; // 메모이제이션
        return dp[x][y];
    }
}