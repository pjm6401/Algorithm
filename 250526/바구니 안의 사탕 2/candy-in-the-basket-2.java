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
        
        if(101-k<=k){
            int sum =0;
            for (int i = 0; i < 101;i++) sum+=basket[i];

            System.out.println(sum);
        }else{
            for (int i = k; i < 101 -k;i++){
             
            int sum = 0;
            for(int j = i; j<=i+k;j++) {
                
                sum += basket[j];
            }

            for(int j = i-1; j>=i-k;j--) sum += basket[j];

            max = Math.max (max,sum);
            }
            System.out.println(max);
        }

        
    }
}