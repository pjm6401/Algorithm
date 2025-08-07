import java.util.*;

public class Main {

    static ArrayList<Line> lines = new ArrayList<>();
    static ArrayList<Line> selected = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            lines.add(new Line(start, end));
        }

        // 정렬(선택 순서에 영향은 없지만 가지치기 최적화에 도움 됨)
        lines.sort(Comparator.comparingInt(line -> line.start));

        backtrack(0);
        System.out.println(max);
    }

    // 백트래킹으로 모든 조합 탐색
    public static void backtrack(int idx) {
        if (idx == lines.size()) {
            if (isValid()) {
                max = Math.max(max, selected.size());
            }
            return;
        }

        // 현재 선분을 선택하는 경우
        selected.add(lines.get(idx));
        backtrack(idx + 1);
        selected.remove(selected.size() - 1);

        // 선택하지 않는 경우
        backtrack(idx + 1);
    }

    // 현재 selected 리스트의 모든 선분이 서로 겹치지 않는지 확인
    public static boolean isValid() {
        for (int i = 0; i < selected.size(); i++) {
            for (int j = i + 1; j < selected.size(); j++) {
                Line a = selected.get(i);
                Line b = selected.get(j);
                // 겹치는 조건: !(a.end < b.start || b.end < a.start)
                if (!(a.end < b.start || b.end < a.start)) {
                    return false; // 겹치는 경우
                }
            }
        }
        return true;
    }

    static class Line {
        int start, end;
        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
