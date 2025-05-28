import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for(int i =0; i<n; i++){
            int temp = arr[i];
            arr[i] *=2;

            for(int j = 0; j<n; j++){
                int sum = 0;
                for(int k = 0; k<n-1; k++){
                    if(k==j) continue;
                    
                    if(k+1 == j && k+2<n){
                        sum += Math.abs(arr[k] - arr[k+2]);
                    }else{
                        sum += Math.abs(arr[k] - arr[k+1]);
                    }

                }
                min = Math.min(min,sum);
            }

            arr[i] = temp;
        }
        System.out.println(min);
    }
}