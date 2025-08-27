import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N을 입력받습니다.
        int n = sc.nextInt();

        // 결과를 저장할 DP 배열을 선언합니다.
        // N이 클 경우 결과값이 int 범위를 초과할 수 있으므로 long 타입을 사용합니다.
        long[] dp = new long[n + 1];

        // 기저 사례(Base Case) 설정
        // N=1일 때
        if (n >= 1) {
            dp[1] = 1;
        }
        
        // N=2일 때
        if (n >= 2) {
            dp[2] = 3;
        }

        // 점화식을 이용하여 dp 배열을 채웁니다.
        // dp[i] = dp[i-1] + 2 * dp[i-2]
        for (int i = 3; i <= n; i++) {
            // 문제에 따라 특정 수로 나눈 나머지를 요구할 수 있습니다.
            // 예를 들어 10007로 나눈 나머지를 구하라는 조건이 있다면,
            // dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007; 과 같이 코드를 수정해야 합니다.
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
        }

        // 최종 결과인 dp[n]을 출력합니다.
        System.out.println(dp[n]);

        sc.close();
    }
}