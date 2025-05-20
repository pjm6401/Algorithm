import java.util.*;

class Segment {
        int start, end;
        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

public class Main {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Segment[] segments = new Segment[N];
        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Segment(x1, x2);
        }

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int minStart = Integer.MAX_VALUE;
            int maxEnd = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                if (i == j) continue; // i번째 선분은 제거
                minStart = Math.min(minStart, segments[j].start);
                maxEnd = Math.max(maxEnd, segments[j].end);
            }

            int length = maxEnd - minStart;
            minLength = Math.min(minLength, length);
        }

        System.out.println(minLength);
    }
}