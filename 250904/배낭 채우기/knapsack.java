import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int [] dp = new int [m+1];
        dp[0] = 0;

        for(int i = 1; i<=m; i++){
            dp[i] = -1;
        }

        for(int i = 0; i<n;i++){
            for (int j = m; j >= w[i]; j--) {  // i번째 아이템을 1번만 고려
                if (dp[j - w[i]] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }
        }

        int ans = 0;
        for(int  i : dp){
            ans = Math.max(ans,i);
        }
        System.out.println(ans);
    }
}