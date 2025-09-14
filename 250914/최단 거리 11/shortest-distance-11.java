import java.util.*;

public class Main {
    static class Edge {
        int des, w;
        Edge(int des, int w) { this.des = des; this.w = w; }
    }

    static class Node implements Comparable<Node> {
        int idx, w;
        Node(int idx, int w) { this.idx = idx; this.w = w; }
        @Override
        public int compareTo(Node o) {
            if (this.w == o.w) return this.idx - o.idx; // 거리 같으면 작은 노드 먼저
            return this.w - o.w;
        }
    }

    static int n, m, a, b;
    static ArrayList<Edge>[] graph;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList[n+1];
        dist = new int[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        a = sc.nextInt();
        b = sc.nextInt();

        // 각 리스트를 목적지 기준으로 정렬 → 역추적 시 사전순 보장
        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.comparingInt(e -> e.des));
        }

        // 다익스트라 시작 (b에서 출발)
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[b] = 0;
        pq.add(new Node(b, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w != dist[cur.idx]) continue;

            for (Edge e : graph[cur.idx]) {
                int next = e.des;
                int cost = cur.w + e.w;
                if (dist[next] > cost) {
                    dist[next] = cost;
                    pq.add(new Node(next, cost));
                }
            }
        }

        // 최단거리 출력
        System.out.println(dist[a]);

        // 경로 복원 (역추적)
        int x = a;
        System.out.print(x + " ");
        while (x != b) {
            for (Edge e : graph[x]) {
                int next = e.des;
                if (dist[next] + e.w == dist[x]) { // 최단경로 조건
                    x = next;
                    break; // 사전순 가장 작은 노드 선택
                }
            }
            System.out.print(x + " ");
        }
    }
}
