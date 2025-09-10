import java.util.*;

public class Main {
    static int n, a, b, c;
    static List<int[]>[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int v = sc.nextInt();
            edges[x].add(new int[]{y, v});
            edges[y].add(new int[]{x, v});
        }

        int[] distA = dijkstra(a);
        int[] distB = dijkstra(b);
        int[] distC = dijkstra(c);

        int ans = 0;
        for (int k = 1; k <= n; k++) {
            if (k == a || k == b || k == c) continue;
            int d = Math.min(distA[k], Math.min(distB[k], distC[k]));
            if (d != Integer.MAX_VALUE) {
                ans = Math.max(ans, d);
            }
        }

        System.out.println(ans);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0], d = cur[1];
            if (d > dist[now]) continue;
            for (int[] e : edges[now]) {
                int next = e[0], cost = e[1];
                if (dist[next] > d + cost) {
                    dist[next] = d + cost;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }
        return dist;
    }
}
