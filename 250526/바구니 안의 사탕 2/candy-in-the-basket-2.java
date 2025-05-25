import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int [] basket = new int [101];

        for (int i = 0; i < n; i++) {
            int candies = sc.nextInt();
            int positions = sc.nextInt();
            basket[positions] += candies;
        }
        
        int max = 0;
        
        
            for (int i = k; i < 101;i++){
             
            int sum = 0;
            for(int j = i-k; j<=i+k;j++) {
                if(j>=0 && j<=100) sum += basket[j];
                
            }


            max = Math.max (max,sum);
            }
            System.out.println(max);
        
    }
}