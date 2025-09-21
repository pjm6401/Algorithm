import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] tempA = new int[n+1];
        int[] tempB = new int[n+1];
        int[] tempC = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            if(num == 1){
                tempA[i] = 1;
            }else if(num == 2){
                tempB[i] = 1;
            }else{
                tempC[i] = 1;
            }
        }

        int[] pA = new int[n+1];
        int[] pB = new int[n+1];
        int[] pC = new int[n+1];

        for (int i = 1; i <= n; i++) {
            pA[i] = pA[i-1] + tempA[i];
            pB[i] = pB[i-1] + tempB[i];
            pC[i] = pC[i-1] + tempC[i];
        }

        int a = 0;
        int b = 0;
        for (int i = 0; i < q; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.print(pA[b] - pA[a-1]+" ");
            System.out.print(pB[b] - pB[a-1]+" ");
            System.out.print(pC[b] - pC[a-1]+" ");
            System.out.println();
        }
    }
}