import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

// 최종 거리(비용, 시간)를 저장하는 클래스
class ResultPair {
    long cost, time;

    public ResultPair(long cost, long time) {
        this.cost = cost;
        this.time = time;
    }

    // 현재 Pair가 p보다 더 큰 값인지 비교하는 메서드
    public boolean isGreaterThan(ResultPair p) {
        if (this.cost != p.cost) {
            return this.cost > p.cost;
        }
        return this.time > p.time;
    }
}

// 그래프의 간선 정보를 담는 클래스
class Edge {
    int to;
    long cost;
    long time;

    public Edge(int to, long cost, long time) {
        this.to = to;
        this.cost = cost;
        this.time = time;
    }
}

// 우선순위 큐에 들어갈 경로 정보를 담는 클래스
class Path implements Comparable<Path> {
    int to;
    long cost;
    long time;

    public Path(int to, long cost, long time) {
        this.to = to;
        this.cost = cost;
        this.time = time;
    }

    // 우선순위 큐의 정렬 기준 (비용 우선, 비용이 같으면 시간 우선)
    @Override
    public int compareTo(Path other) {
        if (this.cost != other.cost) {
            return Long.compare(this.cost, other.cost);
        }
        return Long.compare(this.time, other.time);
    }
}

public class Main {
    public static final long INF = (long) 1e17 + 1;
    public static final int MAX_M = 1000;

    public static int a, b, n, m = 1000;
    // 인접 리스트로 그래프 표현 변경
    public static ArrayList<Edge>[] adj = new ArrayList[MAX_M + 1];
    public static ResultPair[] dist = new ResultPair[MAX_M + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        n = sc.nextInt();

        // 인접 리스트 및 dist 배열 초기화
        for (int i = 1; i <= m; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = new ResultPair(INF, INF);
        }

        // 그래프 구성 (인접 리스트)
        for (int i = 1; i <= n; i++) {
            int cost = sc.nextInt();
            int stopNum = sc.nextInt();

            ArrayList<Integer> stops = new ArrayList<>();
            for (int j = 0; j < stopNum; j++) {
                stops.add(sc.nextInt());
            }

            // 한 노선 내의 모든 정류장 쌍에 대해 간선 추가
            for (int j = 0; j < stopNum; j++) {
                for (int k = j + 1; k < stopNum; k++) {
                    int startNode = stops.get(j);
                    int endNode = stops.get(k);
                    long time = k - j;
                    // 양방향이 아니므로 단방향 간선만 추가
                    adj[startNode].add(new Edge(endNode, cost, time));
                }
            }
        }

        // 시작 위치 설정
        dist[a] = new ResultPair(0, 0);

        // 우선순위 큐를 이용한 다익스트라 알고리즘
        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.add(new Path(a, 0, 0));

        while (!pq.isEmpty()) {
            Path currentPath = pq.poll();
            int u = currentPath.to;
            long currentCost = currentPath.cost;
            long currentTime = currentPath.time;

            // 이미 더 좋은 경로를 찾았다면 무시
            if (currentCost > dist[u].cost || (currentCost == dist[u].cost && currentTime > dist[u].time)) {
                continue;
            }

            // 현재 정점과 연결된 모든 간선을 확인
            for (Edge edge : adj[u]) {
                int v = edge.to;
                long edgeCost = edge.cost;
                long edgeTime = edge.time;
                
                ResultPair newPair = new ResultPair(dist[u].cost + edgeCost, dist[u].time + edgeTime);

                if (dist[v].isGreaterThan(newPair)) {
                    dist[v] = newPair;
                    pq.add(new Path(v, dist[v].cost, dist[v].time));
                }
            }
        }

        // 결과 출력
        if (dist[b].cost == INF) {
            System.out.print("-1 -1");
        } else {
            System.out.print(dist[b].cost + " " + dist[b].time);
        }
    }
}