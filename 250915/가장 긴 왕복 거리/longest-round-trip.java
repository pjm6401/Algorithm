import java.util.*;

public class Main {

    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        // 1. 정방향, 역방향 그래프 2개 선언
        ArrayList<Edge>[] graphForward = new ArrayList[n + 1];
        ArrayList<Edge>[] graphReverse = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graphForward[i] = new ArrayList<>();
            graphReverse[i] = new ArrayList<>();
        }

        // 2. 간선 정보를 입력받아 두 그래프에 모두 추가
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            // 정방향 그래프: start -> end
            graphForward[start].add(new Edge(end, weight));
            // 역방향 그래프: end -> start
            graphReverse[end].add(new Edge(start, weight));
        }

        // 3. 다익스트라 실행
        // distToX: 모든 정점 i -> X 까지의 최단 거리 (역방향 그래프 이용)
        int[] distToX = dijkstra(graphReverse, x, n);
        // distFromX: X -> 모든 정점 i 까지의 최단 거리 (정방향 그래프 이용)
        int[] distFromX = dijkstra(graphForward, x, n);

        // 4. 왕복 시간 계산 및 최댓값 찾기
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            int roundTripTime = distToX[i] + distFromX[i];
            if (roundTripTime > maxTime) {
                maxTime = roundTripTime;
            }
        }
        System.out.print(maxTime);
    }

    // 다익스트라 알고리즘을 별도 함수로 분리
    public static int[] dijkstra(ArrayList<Edge>[] graph, int start, int n) {
        int[] dists = new int[n + 1];
        Arrays.fill(dists, INF);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dists[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int minIdx = currentNode.idx;
            int minDist = currentNode.dist;

            if (minDist > dists[minIdx]) continue;

            for (Edge edge : graph[minIdx]) {
                int nextIdx = edge.des;
                int newDist = minDist + edge.w;

                if (dists[nextIdx] > newDist) {
                    dists[nextIdx] = newDist;
                    pq.add(new Node(nextIdx, newDist));
                }
            }
        }
        return dists;
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