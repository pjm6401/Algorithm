import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_A = 10000;
    
    public static int n, m;
    public static int[] a = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int ans = MAX_A;
        for(int i = 1; i <= MAX_A; i++) {

            boolean possible = true;
            int section = 1;

            int cnt = 0;
            for(int j = 0; j < n; j++) {

                if(a[j] > i) {
                    possible = false;
                    break;
                }
    
                if(cnt + a[j] > i) {
                    cnt = 0;
                    section++;
                }

                cnt += a[j];
            }

            if(possible && section <= m) {
                ans = Math.min(ans, i);
            }
        }

        System.out.print(ans);
    }
}
