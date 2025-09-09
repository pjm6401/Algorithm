import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 옷 개수
        int M = sc.nextInt(); // 총 일수

        int[] s = new int[N];
        int[] e = new int[N];
        int[] v = new int[N];

        for (int i = 0; i < N; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        // dp[day][i] = day일에 i번 옷을 입었을 때의 최대 만족도
        int[][] dp = new int[M + 1][N];
        for (int[] row : dp) Arrays.fill(row, -1);

        // 초기화: 첫날 입을 수 있는 옷이면 dp[1][i] = 0
        for (int i = 0; i < N; i++) {
            if (s[i] <= 1 && 1 <= e[i]) {
                dp[1][i] = 0;
            }
        }

        // 점화식
        for (int day = 2; day <= M; day++) {
            for (int i = 0; i < N; i++) {
                if (s[i] <= day && day <= e[i]) { // i번 옷이 day에 입을 수 있을 때
                    for (int j = 0; j < N; j++) {
                        if (dp[day - 1][j] != -1 && s[j] <= day - 1 && day - 1 <= e[j]) {
                            dp[day][i] = Math.max(dp[day][i],
                                    dp[day - 1][j] + Math.abs(v[i] - v[j]));
                        }
                    }
                }
            }
        }

        // 정답: M일에 가능한 모든 옷 중 최대값
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[M][i]);
        }

        System.out.println(answer);
    }
}
