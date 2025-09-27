import java.util.*;
public class Main {
    public static void main(String[] args) {
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            pq.add(-sc.nextInt());
        }
        for (int i = 0; i < M; i++) {
            int max = pq.poll();
            max +=1;
            pq.add(max);
        }

        System.out.println(-pq.poll());
    }
}