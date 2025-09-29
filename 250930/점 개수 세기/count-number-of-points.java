import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 2. HashSet을 사용하여 중복 좌표를 효율적으로 제거
        Set<Integer> pointSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pointSet.add(Integer.parseInt(st.nextToken()));
        }

        // 3. 정렬을 위해 ArrayList로 변환 후 정렬
        List<Integer> uniqueSortedPoints = new ArrayList<>(pointSet);
        Collections.sort(uniqueSortedPoints);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 4. 이분 탐색(upperBound)을 이용해 범위 내 원소 개수 계산
            int countB = upperBound(uniqueSortedPoints, b);
            int countA = upperBound(uniqueSortedPoints, a - 1);

            sb.append(countB - countA).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * list에서 target 값보다 큰 첫 번째 원소의 인덱스를 반환합니다.
     * 이 인덱스는 list에서 target 값보다 작거나 같은 원소의 개수와 같습니다.
     */
    private static int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size(); // 탐색 범위를 list.size()까지 포함

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // left(또는 right)가 결과 인덱스
    }
}