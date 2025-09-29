import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            pq.add(-sc.nextInt());
        }
        while(pq.size()>=2){
            int x = -pq.poll();
            int y = -pq.poll();

            int minus = Math.abs(x-y);

            pq.add(-minus);
        }

        if(pq.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(-pq.poll());
        }
    }
}