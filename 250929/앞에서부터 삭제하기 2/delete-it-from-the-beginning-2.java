import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        long[] suffixSum = new long[n + 1];
        int[] suffixMin = new int[n + 1];


        suffixSum[n] = 0;
        suffixMin[n] = Integer.MAX_VALUE;

  
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
            suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);
        }

        double maxAvg = 0.0;

        for (int k = 1; k <= n - 2; k++) {
            long sum = suffixSum[k];
            int minVal = suffixMin[k];
            double avg = (sum - minVal) / (double)(n - k - 1);
            maxAvg = Math.max(maxAvg, avg);
        }

        System.out.printf("%.2f\n", maxAvg);
    }
}
