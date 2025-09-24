import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(),1);
        }
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int [] ans = {0};
            map.forEach((key,value)->{
                if(a<= key && key<=b){
                    ans[0] ++;
                }
            });
            System.out.println(ans[0]);
        }
        // Please write your code here.
    }
}