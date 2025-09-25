import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            int k = sc.nextInt();
            set.add(k);
        }
            
        int[] queries = new int[m];
        for (int i = 0; i < m; i++){
            int k = sc.nextInt();
            Integer result = set.ceiling(k);
            if(result == null){
                System.out.println(-1 +" ");
            }else{
                System.out.println(result +" ");
            }
        }
            
        // Please write your code here.
    }
}