import java.util.*;
public class Main {
    public static ArrayList<edge> [] graph;
    public static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList[n+1];

        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            graph[b].add(new edge(a,d));
        }
        int [] dist = new int[n+1];

        for(int i = 1; i<=n; i++){
            dist[i] = 100000001;
        }

        dist[n] = 0;

        pq.add(new Node(n,0));

        while(!pq.isEmpty()){
            int minIdx = pq.peek().idx;
            int minDist = pq.peek().dist;

            pq.poll();

            if(minDist != dist[minIdx]) continue;

            for(int j = 0; j<graph[minIdx].size();j++){
                int targetIdx = graph[minIdx].get(j).des;
                int targetW = graph[minIdx].get(j).w;

                int newDist = dist[minIdx] + targetW;

                if(dist[targetIdx] > newDist){
                    dist[targetIdx] = newDist;
                    pq.add(new Node(targetIdx, newDist));
                }
            }
        }
        int ans = 0;
        for(int i = 1; i<=n; i++){
            if(dist[i] !=100000001 ) ans = Math.max(ans,dist[i]);
        }
        System.out.println(ans);
    }
}

class edge{
    int des;
    int w;

    public edge(int des, int w){
        this.des= des;
        this.w =w;
    }
}
class Node implements Comparable<Node> {
    int idx;    // 노드 번호
    int dist;   // 현재까지 계산된 최단 거리

    Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
        return this.dist - other.dist; // 거리 기준 오름차순 (최소 힙)
    }
}