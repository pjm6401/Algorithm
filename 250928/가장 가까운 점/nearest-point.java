import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pq.add(new Pair(x,y,x+y));
        }

        for (int i = 0; i < m; i++) {
            Pair p = pq.poll();

            p.x += 2;
            p.y += 2;
            p.sum +=4;
            pq.add(p);
        }
        Pair p = pq.poll();
        System.out.println(p.x + " "+p.y);
        
    }
}

class Pair implements Comparable<Pair>{
    int x;
    int y;
    int sum;
    public Pair(int x, int y,int sum){
        this.x = x;
        this.y = y;
        this.sum = sum;
    }

    @Override
    public int compareTo(Pair p){
        if(this.sum == p.sum){

            if(this.x == p.x){
                return this.y - p.y;
            }
            return this.x - p.x;
        }
        return this.sum - p.sum;
    }
}