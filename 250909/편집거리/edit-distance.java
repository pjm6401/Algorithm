import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int n = A.length();
        int m = B.length();
        int [][] dp = new int[n+1][m+1];

        for(int i = 1; i <=n; i++){
            for(int j = 1; j<=m; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1] +1);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        if(dp[n][m] ==0) dp[n][m] = 1;
        System.out.println(m-dp[n][m]+1);
    }
}