import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++)
            B[i] = sc.nextInt();
        
        int cnt = 0;
        Arrays.sort(B);
        for(int i = 0; i < N - M + 1; i++){
            int [] tmp = new int [M];
            for(int j = 0; j< M; j++){
                tmp[j] = A[j+i];
            }
            Arrays.sort(tmp);

            boolean flag = true;

            for(int j = 0; j < M; j++){
                if(tmp[j] != B[j]){
                    flag = false;
                    break;
                }
            }

            if(flag) cnt ++;
        }

        System.out.println(cnt);
    }
}