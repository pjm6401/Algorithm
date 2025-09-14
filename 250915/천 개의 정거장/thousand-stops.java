import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

class ResultPair {
    long cost, time;
    public ResultPair(long cost, long time) { this.cost = cost; this.time = time; }
    public boolean isGreaterThan(ResultPair p) {
        if (this.cost != p.cost) return this.cost > p.cost;
        return this.time > p.time;
    }
}

class Edge {
    int to;
    long cost, time;
    public Edge(int to, long cost, long time) { this.to = to; this.cost = cost; this.time = time; }
}

class Path implements Comparable<Path> {
    int to;
    long cost, time;
    public Path(int to, long cost, long time) { this.to = to; this.cost = cost; this.time = time; }

    @Override
    public int compareTo(Path other) {
        if (this.cost != other.cost) return Long.compare(this.cost, other.cost);
        return Long.compare(this.time, other.time);
    }
}

public class Main {
    public static final long INF = (long) 1e17 + 1;
    public static final int MAX_STATIONS = 1000;
    // 버스 노선이 최대 1000개, 각 노선별 정류장이 최대 1000개일 경우를 대비해 넉넉하게 잡음
    public static final int MAX_NODES = MAX_STATIONS + 1000 * 1000; 

    public static int startStation, endStation, numBuses;
    public static ArrayList<Edge>[] adj = new ArrayList[MAX_NODES + 1];
    public static ResultPair[] dist = new ResultPair[MAX_NODES + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        startStation = sc.nextInt();
        endStation = sc.nextInt();
        numBuses = sc.nextInt();

        for (int i = 1; i <= MAX_NODES; i++) {
            adj[i] = new ArrayList<>();
        }

        int nextNodeId = MAX_STATIONS + 1; // 가상 노드는 1001번부터 시작

        // 그래프 구성 (가상 노드 방식)
        for (int i = 0; i < numBuses; i++) {
            int cost = sc.nextInt();
            int stopNum = sc.nextInt();

            ArrayList<Integer> stops = new ArrayList<>();
            for (int j = 0; j < stopNum; j++) {
                stops.add(sc.nextInt());
            }

            // 이 노선만을 위한 가상 노드 ID들을 할당
            int[] virtualNodes = new int[stopNum];
            for (int j = 0; j < stopNum; j++) {
                virtualNodes[j] = nextNodeId++;
            }

            for (int j = 0; j < stopNum; j++) {
                int realStop = stops.get(j);
                int virtualStop = virtualNodes[j];

                // 1. 탑승 (실제 정류장 -> 가상 정류장)
                adj[realStop].add(new Edge(virtualStop, cost, 0));

                // 3. 하차 (가상 정류장 -> 실제 정류장)
                adj[virtualStop].add(new Edge(realStop, 0, 0));

                // 2. 이동 (이전 가상 정류장 -> 현재 가상 정류장)
                if (j > 0) {
                    int prevVirtualStop = virtualNodes[j-1];
                    adj[prevVirtualStop].add(new Edge(virtualStop, 0, 1));
                }
            }
        }
        
        // dist 배열 초기화
        for (int i = 1; i <= nextNodeId; i++) {
            dist[i] = new ResultPair(INF, INF);
        }

        // 다익스트라 알고리즘
        dist[startStation] = new ResultPair(0, 0);
        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.add(new Path(startStation, 0, 0));

        while (!pq.isEmpty()) {
            Path currentPath = pq.poll();
            int u = currentPath.to;

            if (dist[u].isGreaterThan(new ResultPair(currentPath.cost, currentPath.time))) {
                continue;
            }

            for (Edge edge : adj[u]) {
                int v = edge.to;
                ResultPair newPair = new ResultPair(dist[u].cost + edge.cost, dist[u].time + edge.time);

                if (dist[v].isGreaterThan(newPair)) {
                    dist[v] = newPair;
                    pq.add(new Path(v, dist[v].cost, dist[v].time));
                }
            }
        }

        // 결과 출력
        if (dist[endStation].cost == INF) {
            System.out.print("-1 -1");
        } else {
            System.out.print(dist[endStation].cost + " " + dist[endStation].time);
        }
    }
}