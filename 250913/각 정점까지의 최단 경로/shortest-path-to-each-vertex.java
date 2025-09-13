import java.util.*;

public class Main {
    public static ArrayList<int []>[] graph = new ArrayList[20001];
    public static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    public static int[] dist = new int[20001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u, w});
        }
        for(int i = 1; i<=n; i++){
            dist[i] = 100000001;
        }
        dist[k] = 0;
        pq.add(new int []{0,k});

        while(!pq.isEmpty()){
            int minDist = pq.peek()[0];
            int minIdx = pq.peek()[1];
            pq.poll();

            if(minDist != dist[minIdx]) continue;

            for(int j = 0; j < graph[minIdx].size(); j++){
                int targetIdx = graph[minIdx].get(j)[0];
                int targetDist = graph[minIdx].get(j)[1];

                int newDist = dist[minIdx] + targetDist;

                if(dist[targetIdx]>newDist){
                    dist[targetIdx] = newDist;
                    pq.add(new int[]{newDist, targetIdx});
                }
            }
        }
        for(int i = 1; i<=n; i++){
            if(dist[i] ==100000001 ) dist[i]= -1;
            System.out.println(dist[i]);
        }
    }
}