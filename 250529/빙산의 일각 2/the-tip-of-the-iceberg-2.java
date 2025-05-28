import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            max = Math.max(max,h[i]);
        }
        int count =0;
        for(int i = 1; i<max; i++){
            int [] arr = new int [n];
            for(int j = 0; j<n; j++){
                if(h[j] -1 <=0) arr[j] = 0;
                else arr[j] = 1;
            }

            for(int j = 0; j<n-1; j++){
                if(arr[j] == 0 && arr[j+1] !=0){
                    count++;
                }
                
            }
        }
        System.out.println(count);
        
    }
}