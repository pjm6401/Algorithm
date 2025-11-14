import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();  // 빨간 돌 개수
        int n = sc.nextInt();  // 검은 구간 개수

        // 빨간 돌 위치들을 TreeSet에 저장 (정렬 + 탐색용)
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < c; i++) {
            set.add(sc.nextInt());
        }

        // 구간 입력
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Pair(s, e));
        }

        // 🔥 끝점 기준 오름차순 정렬
        Collections.sort(list);

        int cnt = 0;

        // 각 구간에 대해
        for (Pair p : list) {
            // s 이상인 가장 작은 빨간 돌 위치 찾기
            Integer k = set.ceiling(p.s);

            // 구간 [s, e] 안에 있으면 사용
            if (k != null && k <= p.e) {
                cnt++;
                set.remove(k);  // 이 빨간 돌은 더 이상 사용 불가
            }
        }

        System.out.println(cnt);
    }
}

class Pair implements Comparable<Pair> {
    int s, e;

    public Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.e != p.e) return this.e - p.e;  // 끝점 기준
        return this.s - p.s;                     // 보조로 시작점
    }
}
