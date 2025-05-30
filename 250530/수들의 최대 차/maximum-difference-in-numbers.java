import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int left = 0;
        int maxCount = 0;

        for(int right = 0; right < n; right++) {
            while (arr[right] - arr[left] > k) {
                left++;
            }
            maxCount = Math.max(maxCount, right - left + 1);
        }

        System.out.println(maxCount);
    }
}
