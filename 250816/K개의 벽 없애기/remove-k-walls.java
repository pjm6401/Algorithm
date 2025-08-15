import java.util.*;

public class Main {

    static int n;
    static int k;
    static int[][] grid = new int[100][100];
    static int min = 10001; // 초기값을 충분히 큰 수로 설정
    static int r1, c1, r2, c2;
    static ArrayList<int[]> list = new ArrayList<>(); // '1' (벽)의 위치를 저장하는 리스트
    static ArrayList<int[]> selectedList = new ArrayList<>(); // 제거할 벽 조합을 저장하는 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }
        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        // 조합을 찾기 위한 재귀 함수 호출
        selectWall(0, 0);

        // 만약 min 값이 초기값 그대로라면, 어떤 조합으로도 경로를 찾지 못한 것
        if (min == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    /**
     * 제거할 벽을 k개 선택하는 조합(Combination)을 생성하는 메서드
     * @param cnt 현재까지 선택한 벽의 개수
     * @param start 이번 선택을 시작할 list의 인덱스
     */
    public static void selectWall(int cnt, int start) {
        // k개의 벽을 모두 선택했다면 BFS 실행
        if (selectedList.size() == k) {
            int ans = BFS();
            if (ans != -1) {
                min = Math.min(min, ans);
            }
            return;
        }

        // 조합 생성을 위해 다음 탐색은 현재 인덱스(i) 다음부터 시작하도록 i + 1을 넘겨줌
        for (int i = start; i < list.size(); i++) {
            selectedList.add(list.get(i));
            selectWall(cnt + 1, i + 1);
            selectedList.remove(selectedList.size() - 1);
        }
    }

    public static int BFS() {
        int[][] temp = newGrid(); // 선택된 벽을 제거한 임시 그리드 생성
        boolean[][] visit = new boolean[n][n];
        int[][] step = new int[n][n]; // 각 위치까지의 거리를 저장할 배열

        // Deque는 BFS마다 새로 생성하여 독립성을 보장
        Deque<int[]> dq = new ArrayDeque<>();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        dq.add(new int[]{r1, c1});
        visit[r1][c1] = true;
        step[r1][c1] = 0; // 시작점의 거리는 0

        while (!dq.isEmpty()) {
            int[] arr = dq.poll();
            int x = arr[0];
            int y = arr[1];

            // 목표 지점에 도달하면 현재까지의 거리 반환
            if (x == r2 && y == c2) {
                return step[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isRange(nx, ny) && !visit[nx][ny] && temp[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    dq.add(new int[]{nx, ny});
                    step[nx][ny] = step[x][y] + 1; // 이전 위치의 거리 + 1
                }
            }
        }
        return -1; // 목표 지점에 도달하지 못한 경우
    }
    
    // selectedList를 파라미터로 받을 필요 없이, 전역 변수를 사용
    public static int[][] newGrid() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = grid[i][j];
            }
        }

        // 선택된 벽들을 길(0)으로 만듦
        for (int[] wall : selectedList) {
            temp[wall[0]][wall[1]] = 0;
        }
        return temp;
    }

    public static boolean isRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
}