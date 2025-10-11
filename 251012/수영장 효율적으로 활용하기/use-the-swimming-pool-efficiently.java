import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        long sumArr = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sumArr += arr[i];
        }

        long left = 1;
        long right = sumArr; // 최대합으로 설정
        long answer = sumArr;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (isPossible(mid, arr, m)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean isPossible(long mid, int[] arr, int m) {
        int count = 1;
        long sum = 0;
        for (int num : arr) {
            if (num > mid) return false;
            sum += num;
            if (sum > mid) {
                sum = num;
                count++;
            }
        }
        return count <= m;
    }
}
