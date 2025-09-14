import java.util.*;
public class Main {
    public static ArrayList<Edge> [] graph;
    public static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList [n+1];
        int [] dist = new int [n+1];
        int [] path = new int [n+1];
        int m = sc.nextInt();

        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
            dist[i] = 100000001;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        dist[a] = 0;

        pq.add(new Node(a,0));

        while(!pq.isEmpty()){
            int minIdx = pq.peek().idx;
            int minW = pq.peek().w;

            pq.poll();

            if(minW != dist[minIdx]) continue;

            for(int j = 0; j<graph[minIdx].size(); j++){
                int nextIdx = graph[minIdx].get(j).des;
                int nextDist = graph[minIdx].get(j).w + minW;

                if(dist[nextIdx]>nextDist){
                    dist[nextIdx] = nextDist;
                    pq.add(new Node(nextIdx,nextDist));
                    path[nextIdx] = minIdx;
                }


            }
        }

        int x = b;
        ArrayList<Integer> v = new ArrayList<>();

        v.add(x);
        while(x!=a){
            x = path[x];
            v.add(x);
        }

        System.out.println(dist[b]);
        for(int i = v.size()-1; i>=0; i--){
            System.out.print(v.get(i)+" ");
        }
    }
}

class Edge{
    int des;
    int w;

    public Edge(int des, int w){
        this.des = des;
        this.w = w;
    }
}

class Node implements Comparable<Node>{
    int idx;
    int w;

    public Node(int idx, int w){
        this.idx = idx;
        this.w = w;
    }

    @Override
    public int compareTo(Node node){
        return this.w - node.w;
    }
}