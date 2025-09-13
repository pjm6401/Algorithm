import java.util.*;
public class Main {

    public static ArrayList<Edge>[] graph;
    public static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        graph = new ArrayList[n+1];

        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            graph[a].add(new Edge(b,w));
            graph[b].add(new Edge(a,w));
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
                int nextIdx = graph[minIdx].get(j).des;
                int nextW = graph[minIdx].get(j).w;

                int nextDist = dist[minIdx] + nextW;

                if(dist[nextIdx]> nextDist){
                    dist[nextIdx]=nextDist;

                    pq.add(new Node(nextIdx,nextDist));
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

class Edge {
    int des;
    int w;

    public Edge(int des, int w){
        this.des = des;
        this.w = w;
    }
}

class Node implements Comparable<Node> {
    int idx;
    int dist;

    public Node(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node node){
        return this.dist - node.dist;
    }
}