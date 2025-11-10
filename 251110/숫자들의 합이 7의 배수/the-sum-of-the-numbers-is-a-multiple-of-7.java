import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] first = new int[7];
        Arrays.fill(first, -1);
        first[0] = 0;

        int sum = 0;
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            int mod = sum % 7;

            if (first[mod] == -1) {
                first[mod] = i; // 처음 등장
            } else {
                ans = Math.max(ans, i - first[mod]); // 최대 길이 갱신
            }
        }

        System.out.println(ans);
    }
}
