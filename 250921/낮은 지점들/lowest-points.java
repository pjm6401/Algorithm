import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.compute(x, (k, v) -> v == null ? y : Math.min(v, y));
        }

        long ans = 0; // int -> long 변경
        for (int value : map.values()) {
            ans += value;
        }

        System.out.println(ans);
    }
}
