import java.util.*;

public class Main {

    static class Line {
        int start, end;
        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            lines.add(new Line(start, end));
        }

        // 끝나는 시간 기준으로 정렬
        lines.sort(Comparator.comparingInt(a -> a.end));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (Line line : lines) {
            if (line.start >= lastEnd) {
                count++;
                lastEnd = line.end;
            }
        }

        System.out.println(count);
    }
}
