import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] nums;

    public static boolean isPossible(int minDiff) {
        // 그룹 수
        int count = 0;
        boolean[] used = new boolean[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            if (used[i]) continue;

            for (int j = i + 1; j < 2 * n; j++) {
                if (used[j]) continue;
                if (Math.abs(nums[i] - nums[j]) >= minDiff) {
                    used[i] = true;
                    used[j] = true;
                    count++;
                    break;
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums[2 * n - 1] - nums[0];
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
