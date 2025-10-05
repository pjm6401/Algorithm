import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        boolean[] visit = new boolean[100001]; // boolean이 더 적합

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int j = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && !visit[arr[j]]) {
                visit[arr[j]] = true;
                j++;
            }
            ans = Math.max(ans, j - i);
            visit[arr[i]] = false;
        }

        System.out.println(ans);
    }
}
