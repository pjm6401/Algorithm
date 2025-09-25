import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 1; i<=m; i++){
            set.add(i);
        }

        int[] queries = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            set.remove(a);
            System.out.println(set.last());
        }
        
    }
}