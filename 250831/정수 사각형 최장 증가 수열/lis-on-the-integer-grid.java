import java.util.Scanner;

public class Main {
    // 상하좌우 이동을 위한 배열
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int[][] matrix;
    static int[][] dp;

    public static int dfs(int x, int y) {
        // 1. 이미 계산된 값이 있다면 즉시 반환 (메모이제이션)
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        // 2. 기본 경로 길이는 1 (자기 자신)
        dp[x][y] = 1;

        // 3. 상하좌우 인접 칸 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 격자 범위 체크
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                // 현재 칸보다 값이 더 큰 칸으로만 이동 가능
                if (matrix[nx][ny] > matrix[x][y]) {
                    // 4. DP 테이블 갱신
                    // (현재 경로 길이) vs (1 + 다음 칸에서 시작하는 경로 길이)
                    dp[x][y] = Math.max(dp[x][y], 1 + dfs(nx, ny));
                }
            }
        }
        
        // 5. 최종 계산된 값을 반환
        return dp[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        dp = new int[n][n]; // 0으로 자동 초기화

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int maxPath = 0;
        // 모든 지점을 시작점으로 하여 DFS 실행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(i, j));
            }
        }

        System.out.println(maxPath);
    }
}