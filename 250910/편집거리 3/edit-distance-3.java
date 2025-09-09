import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int n = a.length();
        int m = b.length();
        int [][] dp = new int [n+1][m+1];

        a = "!"+a;
        b = "!"+b;

        for(int i = 1; i<=n;i++){
            for(int j = 1; j<=m; j++){
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else{  
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+2;
                }
            }
        }
        System.out.print(dp[n][m]);
    }
}