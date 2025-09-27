import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            pq.add( sc.nextInt());
            if(pq.size()<3){
            System.out.println(-1);
            
            }else{
                long x = pq.poll();
                long y = pq.poll();
                long z = pq.poll();

                System.out.println(x*y*z);
                pq.add((int)x);
                pq.add((int)y);
                pq.add((int)z);
            }
            
        }

        
    }
}