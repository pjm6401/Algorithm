import java.util.Scanner;

public class Main {
    static int[] dx = {0, -1, 0, 1}; // 동, 북, 서, 남 순서
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int x;
    static int y;
    static char[][] maze = new char[102][102];
    static boolean[][][] visited; // 방문 체크 (x, y, dir)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }
        visited = new boolean[n][n][4];
        run();
    }

    public static void run() {
        x -= 1;
        y -= 1;
        int dir = 0;
        int wall = calcWall(dir);
        int time = 0;

        while (true) {
            // 탈출 성공
            if (!isRange(x, y)) {
                break;
            }

            // 같은 상태 재방문 → 탈출 불가
            if (visited[x][y][dir]) {
                time = -1;
                break;
            }
            visited[x][y][dir] = true;

            if (isWall(x, y, dir)) {
                // 전방이 벽 → 반시계 회전
                dir = calcDir(dir);
                wall = calcWall(dir);
                continue;
            } else if (isRange(x + dx[dir], y + dy[dir]) &&
                       rigthWall(x + dx[dir], y + dy[dir], wall)) {
                // 전방 이동 + 오른쪽 벽 있음
                x += dx[dir];
                y += dy[dir];
                time++;
            } else if (isRange(x + dx[dir], y + dy[dir]) &&
                       !rigthWall(x + dx[dir], y + dy[dir], wall)) {
                // 전방 이동 + 오른쪽 벽 없음 → 이동 후 시계 회전하고 한 칸 더
                x += dx[dir];
                y += dy[dir];
                time++;
                dir = calcDirGo(dir);
                wall = calcWall(dir);
                x += dx[dir];
                y += dy[dir];
                time++;
            } else if (isEscape(x, y, dir, wall)) {
                // 전방이 격자 밖 → 탈출
                x += dx[dir];
                y += dy[dir];
                time++;
                break;
            }
        }

        System.out.println(time);
    }

    public static int calcWall(int dir) {
        return (dir + 3) % 4;
    }

    public static int calcDirGo(int dir) {
        return (dir + 3) % 4;
    }

    public static int calcDir(int dir) {
        return (dir + 1) % 4;
    }

    public static boolean isWall(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        return (isRange(nx, ny) && maze[nx][ny] == '#');
    }

    public static boolean rigthWall(int x, int y, int wall) {
        int nx = x + dx[wall];
        int ny = y + dy[wall];
        return (isRange(nx, ny) && maze[nx][ny] == '#');
    }

    public static boolean isEscape(int x, int y, int dir, int wall) {
        return (isRange(x + dx[wall], y + dy[wall]) &&
                maze[x + dx[wall]][y + dy[wall]] == '#' &&
                !isRange(x + dx[dir], y + dy[dir]));
    }

    public static boolean isRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
}
