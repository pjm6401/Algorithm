import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int n = a.length();
        int m = b.length();

        a = "!"+a;
        b = "!"+b;

       int[][] dp = new int[n + 1][m + 1];

        // LCS 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcsLength = dp[n][m];
        int editDistance = n + m - 2 * lcsLength; // 삽입/삭제만 고려

        System.out.println(editDistance);
    }
}