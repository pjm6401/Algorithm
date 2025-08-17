import java.util.*;

public class Main {

    static int n;
    static int t;
    static int[][] grid;
    // 방향 벡터: 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt(); // 초기 구슬 개수, 전역 변수로 필요 없음
        t = sc.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // 현재 구슬들의 위치를 저장하는 큐
        Queue<int[]> ballQueue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            ballQueue.add(new int[]{r, c});
        }

        // t초 동안 시뮬레이션 진행
        for (int time = 0; time < t; time++) {
            // 이번 시간 단계에서 구슬이 이동할 위치와 해당 위치에 도달할 구슬의 수를 기록
            // key: 위치(r*n+c), value: 해당 위치로 이동할 구슬의 수
            Map<Integer, int[]> nextPositions = new HashMap<>();

            // 현재 큐에 있는 모든 구슬(이번 턴에 움직일 구슬)들을 처리
            while (!ballQueue.isEmpty()) {
                int[] currentPos = ballQueue.poll();
                int r = currentPos[0];
                int c = currentPos[1];

                int maxVal = -1;
                int nextR = r;
                int nextC = c;

                // 4방향 탐색하여 우선순위에 따라 다음 위치 결정
                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];

                    if (isRange(nr, nc)) {
                        if (grid[nr][nc] > maxVal) {
                            maxVal = grid[nr][nc];
                            nextR = nr;
                            nextC = nc;
                        }
                    }
                }
                
                // 다음 위치를 Map에 기록
                int posKey = nextR * n + nextC;
                nextPositions.putIfAbsent(posKey, new int[]{nextR, nextC, 0});
                nextPositions.get(posKey)[2]++; // count 증가
            }

            // 충돌 처리 후 살아남은 구슬들을 다음 턴을 위해 큐에 다시 추가
            for (int[] posInfo : nextPositions.values()) {
                // 해당 위치로 이동한 구슬이 1개인 경우에만 살아남음
                if (posInfo[2] == 1) {
                    ballQueue.add(new int[]{posInfo[0], posInfo[1]});
                }
            }
        }

        // t초 후 남아있는 구슬의 개수 출력
        System.out.println(ballQueue.size());
    }

    public static boolean isRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}