import java.util.*;

public class Main {
    static int n, x, y;
    static char[][] maze;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;
        maze = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }
        System.out.println(run());
    }

    static int run() {
        int dir = 1; // 처음 동쪽(오른쪽) 바라봄
        boolean[][][] visited = new boolean[n][n][4];
        int time = 0;

        while (true) {
            // 탈출 성공
            if (!isRange(x, y)) return time;

            // 같은 상태 반복 → 탈출 불가
            if (visited[x][y][dir]) return -1;
            visited[x][y][dir] = true;

            int rightDir = (dir + 1) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 1. 바라보는 방향 이동 불가 → 왼쪽 회전
            if (!canMove(dir)) {
                dir = (dir + 3) % 4;
                continue;
            }

            // 2. 이동 가능 & 오른쪽 벽 없음 → 이동 후 오른쪽 회전
            if (!hasWallOnRight()) {
                x += dx[dir];
                y += dy[dir];
                time++;
                dir = (dir + 1) % 4;
            }
            // 3. 이동 가능 & 오른쪽에 벽 있음 → 그냥 이동
            else {
                x += dx[dir];
                y += dy[dir];
                time++;
            }
        }
    }

    static boolean canMove(int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        return isRange(nx, ny) && maze[nx][ny] != '#';
    }

    static boolean hasWallOnRight() {
        int rightDir = (dir + 1) % 4;
        int nx = x + dx[rightDir];
        int ny = y + dy[rightDir];
        return !(isRange(nx, ny) && maze[nx][ny] != '#');
    }

    static boolean isRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}
