import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean canFormNGroups(int[] arr, int minDiff, int n) {
    boolean[] used = new boolean[arr.length];
    return dfs(arr, used, 0, n, minDiff);
}

public static boolean dfs(int[] arr, boolean[] used, int index, int remainGroups, int minDiff) {
    if (remainGroups == 0) return true;
    for (int i = index; i < arr.length - 1; i++) {
        if (used[i]) continue;
        for (int j = i + 1; j < arr.length; j++) {
            if (used[j]) continue;
            if (arr[j] - arr[i] >= minDiff) {
                used[i] = used[j] = true;
                if (dfs(arr, used, i + 1, remainGroups - 1, minDiff)) return true;
                used[i] = used[j] = false;
            }
        }
    }
    return false;
}
public static int maximizeMinDifference(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length / 2;
    int left = 0;
    int right = nums[nums.length - 1] - nums[0];
    int answer = 0;

    while (left <= right) {
        int mid = (left + right) / 2;
        if (canFormNGroups(nums, mid, n)) {
            answer = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return answer;
}
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 그룹 수
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(maximizeMinDifference(nums));
    }
}
