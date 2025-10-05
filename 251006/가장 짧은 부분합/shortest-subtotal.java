import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int left = 0, sum = 0, min = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right]; // 오른쪽 포인터 확장

            // 합이 s 이상이면, 왼쪽을 당기며 최소 길이 갱신
            while (sum >= s) {
                min = Math.min(min, right - left + 1);
                sum -= arr[left++];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
