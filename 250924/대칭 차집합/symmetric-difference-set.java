import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            setA.add(A[i]);
        }
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
            setB.add(B[i]);
        }
        
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            
            if(!setA.contains(B[i])){
                cnt ++;
            }
        }

        for (int i = 0; i < n; i++) {
            
            if(!setB.contains(A[i])){
                cnt ++;
            }
        }

        

        System.out.println(cnt);
    }
}