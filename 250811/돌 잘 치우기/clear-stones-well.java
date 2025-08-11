import java.util.*;

public class Main {

    static ArrayList<Index> startPoints = new ArrayList<>(); // 시작점 리스트 (변수명 변경)
    static ArrayList<Index> stonePositions = new ArrayList<>(); // 돌 위치 리스트 (변수명 변경)
    static int n, k, m;
    static int[][] grid = new int[100][100];
    static int maxReachable = 0; // 최대 도달 가능 영역 (변수명 변경)

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    stonePositions.add(new Index(i, j));
                }
            }
        }

        for (int i = 0; i < k; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            startPoints.add(new Index(r, c));
        }

        // 돌 제거 조합을 찾기 위한 재귀 함수 호출
        findCombinations(0, 0, new ArrayList<>());
        
        System.out.println(maxReachable);
    }

    /**
     * 제거할 m개의 돌 조합을 찾는 재귀 함수
     * @param startIdx 조합 생성을 시작할 stonePositions 리스트의 인덱스
     * @param count 현재까지 선택된 돌의 개수
     * @param removedStones 현재 조합에서 제거하기로 선택된 돌들의 리스트
     */
    public static void findCombinations(int startIdx, int count, ArrayList<Index> removedStones) {
        // 1. m개의 돌을 모두 선택한 경우 (재귀 종료 조건)
        if (count == m) {
            // 2. 선택된 돌들을 제거한 후 BFS 실행
            int reachableArea = runBfsWithRemovedStones(removedStones);
            // 3. 최대값 갱신
            maxReachable = Math.max(maxReachable, reachableArea);
            return;
        }

        // 4. 돌 조합 생성
        for (int i = startIdx; i < stonePositions.size(); i++) {
            removedStones.add(stonePositions.get(i));
            findCombinations(i + 1, count + 1, removedStones);
            removedStones.remove(removedStones.size() - 1); // 백트래킹
        }
    }
    
    /**
     * 특정 돌들이 제거된 상태에서 BFS를 실행하여 도달 가능한 영역 크기 계산
     * @param removedStones 제거할 돌들의 위치 리스트
     * @return 도달 가능한 영역의 총 크기
     */
    public static int runBfsWithRemovedStones(ArrayList<Index> removedStones) {
        // a. 시뮬레이션을 위한 임시 그리드 생성
        int[][] tempGrid = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(grid[i], 0, tempGrid[i], 0, n);
        }

        // b. 선택된 돌 제거
        for (Index stone : removedStones) {
            tempGrid[stone.x][stone.y] = 0;
        }

        // c. BFS 실행
        Deque<Index> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        int reachableCount = 0;

        // d. 모든 시작점을 큐에 추가
        for (Index start : startPoints) {
            if (!visited[start.x][start.y]) {
                dq.add(start);
                visited[start.x][start.y] = true;
            }
        }

        while (!dq.isEmpty()) {
            Index current = dq.poll();
            reachableCount++;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isRange(nx, ny) && tempGrid[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.add(new Index(nx, ny));
                }
            }
        }
        return reachableCount;
    }

    public static boolean isRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
}

class Index {
    int x;
    int y;

    public Index(int x, int y) {
        this.x = x;
        this.y = y;
    }
}