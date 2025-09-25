import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            set.add( sc.nextInt());
        }
        
        for(int i = 0; i<k;i++){
            int last = set.last();
            System.out.print(last+" ");
            set.remove(last);
        }
    }
}