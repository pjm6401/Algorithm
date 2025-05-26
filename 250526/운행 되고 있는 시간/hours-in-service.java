import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
   
        int maxTime = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            maxTime = Math.max(maxTime,B[i]);
        }
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<N; i++){
            int [] workTime = new int [maxTime+1]; 
            int count = 0;
            for(int j = 0; j<N; j++){
                if(i==j) continue;

                for(int k = A[j]; k<B[j]; k++){
                    workTime[k]++;
                }

            }
            for(int l =1; l<maxTime+1; l++){
                if(workTime[l]>=1) count++;
            }
            max = Math.max(max,count);
        }

        System.out.println(max);
    }
}