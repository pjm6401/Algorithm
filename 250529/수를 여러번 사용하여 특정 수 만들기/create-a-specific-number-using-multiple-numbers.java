import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int aMaxLen = C/A;
        int bMaxLen = C/B;
        int firstSum = 0;
        for(int i = 0; i<=aMaxLen; i++){
            for(int j = 0; j<=bMaxLen; j++){
                int sum = 0;
                if(A*i + B*j <= C){
                    sum += A*i + B*j;
                    firstSum = Math.max(firstSum,sum);
                }
            }
        }

        int secondSum = 0;
        for(int i = 0; i<=bMaxLen; i++){
            for(int j = 0; j<=aMaxLen; j++){
                int sum = 0;
                if(A*j + B*i<=C) {
                    sum += A*j + B*i;
                    secondSum = Math.max(secondSum,sum);
                };
            }
        }

        int max = Math.max(firstSum,secondSum);
        System.out.println(max);
    }
}