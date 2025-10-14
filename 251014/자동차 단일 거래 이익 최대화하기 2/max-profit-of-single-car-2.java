import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        int start = prices[0];
        int max = 0;
        for(int i = 1; i < n; i++){
            if(start<prices[i]){
                max = Math.max(max,prices[i]-start);
            }else{
                start = prices[i];
            }
        }
        System.out.println(max);
    }
}