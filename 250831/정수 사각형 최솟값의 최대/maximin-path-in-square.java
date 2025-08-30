import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = matrix[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]);
            dp[0][i] = Math.min(dp[0][i - 1], matrix[0][i]);
        }

        // 3. 나머지 DP 테이블 채우기
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max( Math.min(dp[i-1][j], matrix[i][j]), Math.min(dp[i][j-1], matrix[i][j]) );
            }
        }

        // 최종 목적지 (N, N)의 결과 출력
        System.out.println(dp[n - 1][n - 1]);
    }
}