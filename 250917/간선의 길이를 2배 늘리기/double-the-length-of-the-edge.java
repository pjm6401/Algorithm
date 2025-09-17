import java.util.*;

public class Main {

    public static int n, m;
    public static int[] dists;
    public static int[] path;
    public static ArrayList<Edge>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList[n + 1];
        path = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        // 1. 원래 최단거리 구하기
        int result = dijkstra(1);
        
        // 2. 최단경로 추적해서 간선 모으기
        List<int[]> pathEdges = new ArrayList<>();
        int cur = n;
        while (cur != 1) {
            int prev = path[cur];
            pathEdges.add(new int[]{prev, cur});
            cur = prev;
        }

        // 3. 각 간선을 2배로 하고 다시 다익스트라 돌려보기
        int maxDist = result;
        for (int[] e : pathEdges) {
            int u = e[0], v = e[1];

            // 간선 2배로
            for (Edge edge : graph[u]) {
                if (edge.des == v) edge.w *= 2;
            }
            for (Edge edge : graph[v]) {
                if (edge.des == u) edge.w *= 2;
            }

            // 다시 다익스트라
            int newDist = dijkstra(1);
            maxDist = Math.max(maxDist, newDist);

            // 원래 값 복원
            for (Edge edge : graph[u]) {
                if (edge.des == v) edge.w /= 2;
            }
            for (Edge edge : graph[v]) {
                if (edge.des == u) edge.w /= 2;
            }
        }

        // 4. 차이 출력
        System.out.println(maxDist - result);
    }

    // 다익스트라 함수
    public static int dijkstra(int start) {
        dists = new int[n + 1];
        Arrays.fill(dists, 250000001);
        dists[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int curIdx = now.idx;
            int curDist = now.dist;

            if (curDist != dists[curIdx]) continue;

            for (Edge edge : graph[curIdx]) {
                int nextIdx = edge.des;
                int nextDist = curDist + edge.w;

                if (dists[nextIdx] > nextDist) {
                    dists[nextIdx] = nextDist;
                    pq.add(new Node(nextIdx, nextDist));
                    path[nextIdx] = curIdx; // 이전 노드 기록
                }
            }
        }
        return dists[n];
    }
}

class Edge {
    int des;
    int w;

    public Edge(int des, int w) {
        this.des = des;
        this.w = w;
    }
}

class Node implements Comparable<Node> {
    int idx;
    int dist;

    public Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node node) {
        return this.dist - node.dist;
    }
}
