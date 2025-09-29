import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
           arr[i] = sc.nextInt();
        double min = 0;
        for(int k = 1; k<=n-2; k++){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = k; i<n; i++){
                pq.add(arr[i]);
            }
            
            pq.poll();
            int sum = 0;
            while(!pq.isEmpty()){
                int x = pq.poll();

                sum += x;
            }

            min = Math.max(min,sum/(n-k-1));
        }

        System.out.printf("%.2f\n", min);
    }
}