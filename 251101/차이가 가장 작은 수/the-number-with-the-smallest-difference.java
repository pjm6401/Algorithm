import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        int min = Integer.MAX_VALUE;

        while(true){
            int start = set.first();
            int last = set.last();

            if(last - start<m) break;

            min = Math.min(min, last - start);

            if(set.lower(last) - start > last - set.higher(start)){
                set.remove(last);
            }else{
                set.remove(start);
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }
}