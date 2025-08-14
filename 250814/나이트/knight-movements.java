import java.util.*;

public class Main {
    static int n, r1, c1, r2, c2;
    static int[][] step = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        for (int i = 0; i < n; i++) Arrays.fill(step[i], -1);

        System.out.println(BFS());
    }

    public static int BFS() {
        int[] dx = {-2,-1,1,2,2,1,-1,-2};
        int[] dy = {1,2,2,1,-1,-2,-2,-1};

        Queue<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{r1, c1});
        step[r1][c1] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0], y = cur[1];

            if (x == r2 && y == c2) return step[x][y];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && step[nx][ny] == -1) {
                    step[nx][ny] = step[x][y] + 1;
                    dq.add(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}
