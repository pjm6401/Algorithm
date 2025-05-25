import java.util.Scanner;
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
        
        for(int i = 0; i < N - M + 1; i++){
            int count = 0;
            for(int j = i; j< M + i; j++){
                for(int k = 0; k < M; k++){
                    if(B[k] == A[j]){
                        count++;
                        break;
                    }
                }
            }
            if(count>=M){
                cnt++;
            }
        }

        System.out.println(cnt++);
    }
}