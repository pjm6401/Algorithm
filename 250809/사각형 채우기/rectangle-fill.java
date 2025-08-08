import java.util.Scanner;
public class Main {


    public static final int MAX_N = 1000;
    public static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 초기값 설정
        dp[1] = 1;
        dp[2] = 2;

        // 점화식을 이용하여 dp 배열 채우기
        // dp[i] = dp[i - 1] + dp[i - 2]
        for (int i = 3; i <= n; i++) {
            // 문제에 따라 결과값을 특정 수로 나눈 나머지를 요구할 수 있습니다.
            // 예: dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            dp[i] = dp[i - 1] + dp[i - 2]  % 10007 ;
        }

        System.out.println(dp[n]);
    }
}