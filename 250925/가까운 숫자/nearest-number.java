import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int n = sc.nextInt();
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            set.add(x);

            if(set.higher(x) != null){
                int temp = set.higher(x) - x;
                length = Math.min(length,temp);
            }

            if(set.lower(x) != null){
                int temp = x - set.lower(x);
                length = Math.min(length,temp);
            }
            System.out.println(length);
        }
        
    }
}