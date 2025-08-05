import java.util.*;

class State {
    int x;
    int y;

    public State(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}

public class Main {
    static int[] dx = {0, 1, 0, -1}; // R, D, L, U
    static int[] dy = {1, 0, -1, 0};
    static int m;
    static int n;
    static int k;
    static int[][] grid = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        // 사과 위치 입력
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            grid[x][y] = 1; // 사과
        }

        int startX = 0, startY = 0;
        int time = 0;
        boolean[][] visit = new boolean[n][n];

        // 뱀 몸체 저장 (머리: front, 꼬리: rear)
        Deque<State> dq = new ArrayDeque<>();
        dq.offerFirst(new State(startX, startY));
        visit[startX][startY] = true;

        boolean flag = true;

        // 명령 실행
        for (int i = 0; i < k && flag; i++) {
            char d = sc.next().charAt(0);
            int p = sc.nextInt();
            int dir = getDir(d);

            for (int j = 0; j < p; j++) {
                int nx = startX + dx[dir];
                int ny = startY + dy[dir];
                time++;

                // 범위 밖이거나 자기 몸과 충돌
                if (!isRange(nx, ny) || (visit[nx][ny] && !isTail(nx, ny, dq))) {
                    flag = false;
                    break;
                }

                // 머리 이동
                dq.offerFirst(new State(nx, ny));
                visit[nx][ny] = true;

                if (grid[nx][ny] == 1) {
                    // 사과 있으면 먹고 길이 증가 (꼬리 안 자름)
                    grid[nx][ny] = 0;
                } else {
                    // 사과 없으면 꼬리 제거
                    State tail = dq.pollLast();
                    visit[tail.getX()][tail.getY()] = false;
                }

                startX = nx;
                startY = ny;
            }
        }

        System.out.println(time);
    }

    public static int getDir(char d) {
        if (d == 'R') return 0;
        else if (d == 'D') return 1;
        else if (d == 'L') return 2;
        else return 3; // 'U'
    }

    public static boolean isRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    // 이동하려는 칸이 현재 꼬리면 충돌 아님
    public static boolean isTail(int x, int y, Deque<State> dq) {
        State tail = dq.peekLast();
        return tail != null && tail.getX() == x && tail.getY() == y;
    }
}
