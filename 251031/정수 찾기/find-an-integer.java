import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        int m = sc.nextInt();
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();

            if(set.contains(a)){
                System.out.println(1);
            }else{
                 System.out.println(0);
            }
        }
        
    }
}