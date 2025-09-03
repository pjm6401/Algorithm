import java.util.*;

public class Main {
    static class Segment implements Comparable<Segment> {
        int start, end;
        Segment(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Segment o) {
            if (this.end == o.end) return this.start - o.start;
            return this.end - o.end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Segment[] arr = new Segment[N];

        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[i] = new Segment(s, e);
        }

        Arrays.sort(arr);

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (Segment seg : arr) {
            if (seg.start > lastEnd) { // 끝점 공유 불가 → start > lastEnd
                count++;
                lastEnd = seg.end;
            }
        }

        System.out.println(count);
    }
}
