import java.util.Scanner;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int absX, x;

    public Pair(int absX, int x) {
        this.absX = absX;
        this.x = x;
    }

    @Override
    public int compareTo(Pair p) {
        if(this.absX == p.absX)
            return this.x - p.x;    
        return this.absX - p.absX;      
    }
}

public class Main {

    public static int n;
    
    public static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(x != 0)
                pq.add(new Pair(Math.abs(x), x));

            else {
                if(pq.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(pq.poll().x);
            }
        }
    }
}
