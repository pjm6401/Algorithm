import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 점 개수
        int q = sc.nextInt(); // 질의 개수
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        // 1. 점들을 정렬
        Arrays.sort(points);

        // 2. 좌표 압축: 점 위치를 1 ~ N으로 변환
        // map: 실제 좌표 -> 압축 좌표
        Map<Integer, Integer> comp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            comp.put(points[i], i + 1); // 1-based index
        }

        // 3. 압축 좌표에 개수 저장 (여기서는 각 점이 1개씩 존재)
        int[] cnt = new int[n + 1];
        for (int p : points) {
            cnt[comp.get(p)]++;
        }

        // 4. 부분합 배열 생성
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + cnt[i];
        }

        // 5. 질의 처리
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            // l 이상인 첫 좌표 idxL, r 이하인 마지막 좌표 idxR 찾기
            int idxL = lowerBound(points, l) + 1; // 압축 좌표 (1-based)
            int idxR = upperBound(points, r);     // 압축 좌표 (1-based)

            if (idxL > idxR) {
                System.out.println(0);
            } else {
                System.out.println(prefix[idxR] - prefix[idxL - 1]);
            }
        }
    }

    // lower_bound: 처음으로 key 이상이 나오는 위치
    static int lowerBound(int[] arr, int key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo; // 0-based index
    }

    // upper_bound: 처음으로 key 초과가 나오는 위치
    static int upperBound(int[] arr, int key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo; // 0-based index
    }
}
