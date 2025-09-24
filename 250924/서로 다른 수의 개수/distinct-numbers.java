import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int k  = sc.nextInt();
            set.add(k);
        }
        System.out.println(set.size());
    }
}