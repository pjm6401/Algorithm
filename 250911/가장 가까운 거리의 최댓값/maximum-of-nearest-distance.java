import java.util.*;

public class Main {
    static int[] dist;
    static List<int[]>[] edges; // 인접 리스트 (to, weight)
    static int n, a, b, c;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int v = sc.nextInt();
            edges[x].add(new int[]{y, v});
            edges[y].add(new int[]{x, v});
        }

        System.out.println(calc());
    }

    public static void init() {
        dist = new int[n + 1];
        visit = new boolean[n + 1];
        Arrays.fill(dist, 1000000001);
    }

    public static int dijkstra(int start, int targetA, int targetB, int targetC) {
        init();
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0], d = cur[1];
            if (visit[now]) continue;
            visit[now] = true;

            for (int[] e : edges[now]) {
                int next = e[0];
                int cost = e[1];
                if (dist[next] > d + cost) {
                    dist[next] = d + cost;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        int da = dist[targetA], db = dist[targetB], dc = dist[targetC];
        if (da == 1000000001 || db == 1000000001 || dc == 1000000001) return -1;
        return Math.min(da, Math.min(db, dc));
    }

    public static int calc() {
        int ans = 0;
        for (int k = 1; k <= n; k++) {
            if (k == a || k == b || k == c) continue;
            int d = dijkstra(k, a, b, c);
            if (d != -1) ans = Math.max(ans, d);
        }
        return ans;
    }
}
