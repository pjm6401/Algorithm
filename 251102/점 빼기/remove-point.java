import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, TreeSet<Integer>> map = new TreeMap<>();
        TreeSet<Integer> xSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            map.putIfAbsent(x, new TreeSet<>());
            map.get(x).add(y);
            xSet.add(x);
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            Integer targetX = xSet.ceiling(x);

            if (targetX == null) {
                System.out.println("-1 -1");
                continue;
            }

            TreeSet<Integer> ys = map.get(targetX);
            int targetY = ys.first();
            System.out.println(targetX + " " + targetY);
            ys.remove(targetY);

            // y가 다 사라졌다면 x 자체 삭제
            if (ys.isEmpty()) {
                xSet.remove(targetX);
                map.remove(targetX);
            }
        }
    }
}
