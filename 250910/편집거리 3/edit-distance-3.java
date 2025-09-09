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

        // 초기화: 한쪽 문자열이 비어있을 때 편집거리
        for (int i = 0; i <= n; i++) dp[i][0] = i; // 삭제
        for (int j = 0; j <= m; j++) dp[0][j] = j; // 삽입

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        System.out.print(dp[n][m]);
    }
}