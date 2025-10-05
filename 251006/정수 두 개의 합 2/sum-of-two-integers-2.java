import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr); // 정렬

        int left = 0, right = n - 1;
        int cnt = 0;

        while (left < right) {
            if (arr[left] + arr[right] <= k) {
                // arr[left]는 arr[right], arr[right-1], ..., arr[left+1]과 모두 조건을 만족
                cnt += (right - left);
                left++;
            } else {
                right--;
            }
        }

        System.out.println(cnt);
    }
}
