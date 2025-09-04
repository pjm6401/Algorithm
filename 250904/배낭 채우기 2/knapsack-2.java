import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        int [] dp = new int [m+1];
        dp[0] = 0;

        for(int i = 1; i<=m; i++){
            for(int j = 0; j<n; j++){
                if(i<weight[j]) continue;
                dp[i] = Math.max(dp[i], dp[i-weight[j]] + value[j]);
            }
        }

        int ans = 0;

        for(int i:dp){
            ans = Math.max(ans,i);
        }

        System.out.println(ans);
    }
}