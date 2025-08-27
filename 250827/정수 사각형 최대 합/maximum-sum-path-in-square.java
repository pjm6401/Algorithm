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

        // 1. 초기값 설정
        dp[0][0] = matrix[0][0];

        // 2. 첫 번째 행 초기화 (왼쪽에서 오는 경우만 있음)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        // 3. 첫 번째 열 초기화 (위에서 오는 경우만 있음)
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        // 4. 나머지 DP 테이블 채우기
        // dp[i][j] = matrix[i][j] + max(위에서 온 경로, 왼쪽에서 온 경로)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = matrix[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // 최종 결과는 dp[n-1][n-1]에 저장됨
        System.out.println(dp[n - 1][n - 1]);
    }
}