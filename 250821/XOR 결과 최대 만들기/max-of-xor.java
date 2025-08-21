import java.util.*;

public class Main {
    static int n;
    static int m;
    static int max = 0;
    static int [] A = new int [20];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        choice(0,0);

        System.out.println(max);
    }


    public static void choice (int cnt, int start){
        if(cnt == m){
            int result = 0;
            for(int n : list){
                result ^= n;
            }
            
            max = Math.max(max,result);
            return;
        }

        for(int i = start; i<n; i++){
            list.add(A[i]);
            choice(cnt+1, i+1);
            list.remove(list.size()-1);
        }

    }
}