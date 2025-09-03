import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        int [] dp = new int [m+1];
        dp[0] = 0;

        for(int i = 1; i<=m; i++){
            dp[i] = Integer.MIN_VALUE;
        }

        for(int i =1; i<=m; i++){
            for(int j =0; j<n; j++){
                if(i>=coin[j]){
                    if(dp[i-coin[j]] == Integer.MIN_VALUE) continue;

                    dp[i] = Math.max(dp[i], dp[i-coin[j]]+1);
                }
            }
        }

        int ans = dp[m];

        if(ans == Integer.MIN_VALUE) ans = -1;

        System.out.println(ans);
    }
}