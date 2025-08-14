import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100;
    public static final int MAX_M = 100;
    
    public static int n, m;

    public static int[][] a = new int[MAX_N][MAX_M];

    // bfs에 필요한 변수들 입니다.
    public static int[][] step = new int[MAX_N][MAX_M];
    public static boolean[][] visited = new boolean[MAX_N][MAX_M];
    public static Queue<Pair> q = new LinkedList<>();

    public static int ans = INT_MAX;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    // 격자를 벗어나지 않으면서, 뱀도 없고, 아직 방문한 적이 없는 곳이라면
    // 지금 이동하는 것이 최단거리임을 보장할 수 있으므로 가야만 합니다. 
    public static boolean canGo(int x, int y) {
        return inRange(x, y) && a[x][y] == 1 && !visited[x][y];
    }

    // queue에 새로운 위치를 추가하고
    // 방문 여부를 표시해줍니다.
    // 시작점으로 부터의 최단거리 값도 갱신해줍니다.
    public static void push(int x, int y, int s) {
        q.add(new Pair(x, y));
        visited[x][y] = true;
        step[x][y] = s;
    }

    // bfs를 통해 최소 이동 횟수를 구합니다.
    public static void findMin() {
        // queue에 남은 것이 없을때까지 반복합니다.
        while(!q.isEmpty()) {
            // queue에서 가장 먼저 들어온 원소를 뺍니다.
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;

            int[] dx = new int[]{0, 1,  0, -1};
            int[] dy = new int[]{1, 0, -1,  0};
            
            // queue에서 뺀 원소의 위치를 기준으로 4방향을 확인해봅니다.
            for(int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // 아직 방문한 적이 없으면서 갈 수 있는 곳이라면
                // 새로 queue에 넣어줍니다.
                if(canGo(newX, newY)) {
                    // 최단 거리는 이전 최단거리에 1이 증가하게 됩니다. 
                    push(newX, newY, step[x][y] + 1);
                }
            }
        }

        // 우측 하단에 가는 것이 가능할때만
        // 답을 갱신해줍니다.
        if(visited[n - 1][m - 1])
            ans = step[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();

         // bfs를 이용해 최소 이동 횟수를 구합니다.
        // 시작점을 queue에 넣고 시작합니다.
        push(0, 0, 0);
        findMin();

        // 출력:
        if(ans == INT_MAX)  // 불가능한 경우라면
            ans = -1;       // -1을 답으로 넣어줍니다.

        System.out.println(ans);
    }
}
