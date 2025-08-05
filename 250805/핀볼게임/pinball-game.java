import java.util.Scanner;

public class Main {
    static int n;
    static int[][] grid = new int[101][101];
    static int[] dx = {0, 1, 0, -1}; // R, D, L, U
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 거울 정보 입력
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int max = 0;

        // 1. 왼쪽 변 → 오른쪽으로 쏘기
        for (int i = 0; i < n; i++) {
            max = Math.max(max, simulate(i, 0, 0));
        }

        // 2. 오른쪽 변 → 왼쪽으로 쏘기
        for (int i = 0; i < n; i++) {
            max = Math.max(max, simulate(i, n - 1, 2));
        }

        // 3. 위쪽 변 → 아래로 쏘기
        for (int j = 0; j < n; j++) {
            max = Math.max(max, simulate(0, j, 1));
        }

        // 4. 아래쪽 변 → 위로 쏘기
        for (int j = 0; j < n; j++) {
            max = Math.max(max, simulate(n - 1, j, 3));
        }

        System.out.println(max);
    }

    // 빔 시뮬레이션
    public static int simulate(int x, int y, int dir) {
        int time = 1; // 시작 위치 포함
        if (grid[x][y] != 0) {
            dir = newDir(dir, grid[x][y]);
        }
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (isRange(nx, ny)) {
            time++;
            if (grid[nx][ny] != 0) {
                dir = newDir(dir, grid[nx][ny]);
            }
            nx += dx[dir];
            ny += dy[dir];
        }
        time++;
        return time;
    }

    // 방향 전환
    public static int newDir(int dir, int wall) {
        if (dir == 0 && wall == 1) return 3;
        if (dir == 0 && wall == 2) return 1;
        if (dir == 1 && wall == 1) return 2;
        if (dir == 1 && wall == 2) return 0;
        if (dir == 2 && wall == 1) return 1;
        if (dir == 2 && wall == 2) return 3;
        if (dir == 3 && wall == 1) return 0;
        return 2; // (dir == 3 && wall == 2)
    }

    public static boolean isRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
}
