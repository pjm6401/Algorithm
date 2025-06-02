import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        

        long minDiff = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minDiff = Math.min(minDiff, (long) arr[n + i] - arr[i]);
        }

        System.out.println(minDiff);
    }
}
