import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        HashSet<Integer> window = new HashSet<>();
        int ans = -1;

        for (int i = 0; i < n; i++) {
            // 중복 발견 시 최대값 갱신
            if (window.contains(arr[i])) {
                ans = Math.max(ans, arr[i]);
            }

            // 현재 값 추가
            window.add(arr[i]);

            // 윈도우 크기 유지 (i - k 인 원소 제거)
            if (i >= k) {
                window.remove(arr[i - k]);
            }
        }

        System.out.println(ans);
    }
}
