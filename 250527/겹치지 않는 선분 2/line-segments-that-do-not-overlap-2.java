import java.util.*;

public class Main {
    static class Segment {
        int x1, x2;

        Segment(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Segment[] segments = new Segment[n];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Segment(x1, x2);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean intersects = false;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if ((segments[i].x1 < segments[j].x1 && segments[i].x2 > segments[j].x2) ||
                    (segments[i].x1 > segments[j].x1 && segments[i].x2 < segments[j].x2)) {
                    intersects = true;
                    break;
                }
            }
            if (!intersects) count++;
        }

        System.out.println(count);
    }
}
