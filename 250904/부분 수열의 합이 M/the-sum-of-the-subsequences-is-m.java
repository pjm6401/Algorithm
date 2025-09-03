import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = sc.nextInt();
        }
        int [] dp = new int [m+1];

        for(int i = 0; i<=m; i++){
           

            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for(int i = 1; i<=n; i++){
            for(int j = m; j>=1; j--){
                if(j-arr[i]>=0){
                    if(dp[j-arr[i]] == Integer.MAX_VALUE) continue;
                    dp[j] = Math.min(dp[j],dp[j-arr[i]]+1);
                }
                
            }
        }

        int ans = dp[m];
        if(ans == Integer.MAX_VALUE) ans = -1;

        System.out.println(ans);
    }
}