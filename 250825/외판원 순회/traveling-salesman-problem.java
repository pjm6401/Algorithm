import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // INF 값은 (최대 도시 수 * 최대 비용) 보다 큰 값으로 설정해야 합니다.
    static final int INF = 16 * 1_000_000 + 1; 
    static int n;
    static int[][] cost;
    static int[][] dp;
    static int ALL_VISITED;

    public static void main(String[] args) {
        //--- 입력 처리 시작 ---//
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        cost = new int[n][n];
        dp = new int[n][1 << n];
        ALL_VISITED = (1 << n) - 1;

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1); // -1로 초기화하여 0 비용과 구분 (INF로도 가능)
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        sc.close();
        //--- 입력 처리 끝 ---//

        int result = tsp(0, 1); // 0번 도시에서 시작, 방문 상태는 0번만(mask: 1)
        System.out.println(result);
    }

    /**
     * @param current 현재 방문 중인 도시
     * @param visitedMask 현재까지 방문한 도시들의 집합 (비트마스크)
     * @return 남은 도시들을 방문하고 출발점으로 돌아오는 최소 비용
     */
    static int tsp(int current, int visitedMask) {
        // 1. 모든 도시를 방문 완료한 경우
        if (visitedMask == ALL_VISITED) {
            // 출발점(0번)으로 돌아가는 경로가 없으면 무효한 경로
            if (cost[current][0] == 0) {
                return INF;
            }
            // 출발점으로 돌아가는 비용 반환
            return cost[current][0];
        }

        // 2. 이미 계산된 상태라면 저장된 값을 반환 (Memoization)
        if (dp[current][visitedMask] != -1) {
            return dp[current][visitedMask];
        }

        // 3. 현재 상태에서 다음 도시로 이동하는 모든 경우를 탐색
        dp[current][visitedMask] = INF; // 현재 경로의 최소 비용을 INF로 초기화
        for (int next = 0; next < n; next++) {
            // 만약 next 도시를 아직 방문하지 않았고, 길이 있다면
            if ((visitedMask & (1 << next)) == 0 && cost[current][next] != 0) {
                // 다음 상태로 재귀 호출하고, 그 결과에 현재 이동 비용을 더함
                int newCost = cost[current][next] + tsp(next, visitedMask | (1 << next));
                
                // 기존 최소 비용과 새로 계산된 비용을 비교하여 갱신
                dp[current][visitedMask] = Math.min(dp[current][visitedMask], newCost);
            }
        }

        return dp[current][visitedMask];
    }
}