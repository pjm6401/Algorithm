import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++){
            bombs[i] = sc.nextInt();
            max = Math.max(max,bombs[i]);
        }
        int [] result = new int [max+1];    
        

        for(int i = 0; i<n; i++){
            int bomb = bombs[i];
            boolean boom = false;
            for(int j = i+1; j <= i+k; j++ ){
                if(j>=n) break;
                if (bomb == bombs[j] && boom == false){
                    boom = true;
                    break;
                } 
            }
            for(int j = i-1; j >= i-k; j--){
                if(j<0) break;
                if (bomb == bombs[j] && boom == false){
                    boom = true;
                    break;
                } 
            }
            if(boom){
                result[bomb] ++;
            }

        }
        int index= 0;
        int cnt = 0;
        for(int i = 1; i< max+1; i++){
            if(result[i]>cnt){
                cnt = result[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}