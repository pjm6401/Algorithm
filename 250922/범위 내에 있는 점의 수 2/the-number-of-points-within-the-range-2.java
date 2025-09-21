import java.util.*;
public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
            map.put(points[i],1);
        }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = 0;

            for(int j = a; j<=b; j++){
                if(map.containsKey(j)){
                    ans+=1;
                }
            }
            System.out.println(ans);
        }
    }
}