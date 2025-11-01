import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        int minDiff = Integer.MAX_VALUE;

        for (int a : set) {
            Integer b = set.ceiling(a + m); // a+m 이상 중 가장 작은 값
            if (b != null) {
                minDiff = Math.min(minDiff, b - a);
            }
        }

        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }
}
