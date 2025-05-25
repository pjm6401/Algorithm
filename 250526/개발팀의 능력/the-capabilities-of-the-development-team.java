import java.util.Scanner;
public class Main {

    static int [] arr = new int [5];
    
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i<5; i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        int min = 5000;
        for(int i = 0; i<4; i++){
            for(int j=i; j<5; j++){
                min = Math.min(min,diff(i,j));
            }
        }

        System.out.println(min);
    }

    public static int diff(int i, int j){
        int sum1 = arr[i]+arr[j];
        int sumTmp = sum - sum1;
        int max = 0;
        int min = 1001;
        for(int k =0; k < 5; k++){
            if(k==i||k==j) continue;
            max = Math.max(sum1,Math.max(arr[k],sumTmp-arr[k]));
            min = Math.min(sum1,Math.min(arr[k],sumTmp-arr[k]));
        }
        
        return max - min;
    }
}