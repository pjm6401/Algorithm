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

        long sum = 0; // long으로 변경
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            int mod = (int)(sum % 7);

            if (first[mod] == -1) {
                first[mod] = i;
            } else {
                ans = Math.max(ans, i - first[mod]);
            }
        }

        System.out.println(ans);
    }
}
