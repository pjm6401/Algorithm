import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            Integer target = set.floor(sc.nextInt());
            if(target !=null){
                System.out.println(target);
                set.remove(target);
            }else{
                System.out.println(-1);
            }
        }
        // Please write your code here.
    }
}