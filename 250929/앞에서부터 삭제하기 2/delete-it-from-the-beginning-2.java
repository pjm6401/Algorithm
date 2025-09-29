import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        double maxAvg = 0.0;
        
        for (int k = 1; k <= n - 2; k++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int sum = 0;
            
            for (int i = k; i < n; i++) {
                pq.add(arr[i]);
                sum += arr[i];
            }

            int minVal = pq.poll();
            sum -= minVal;

            double avg = sum / (double)(pq.size());

            maxAvg = Math.max(maxAvg, avg);
        }
        
        System.out.printf("%.2f\n", maxAvg);
    }
}
