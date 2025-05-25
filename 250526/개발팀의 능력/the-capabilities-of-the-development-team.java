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
        int min = 5001;
        for(int i = 0; i<4; i++){
            for(int j=i+1; j<5; j++){
                min = Math.min(min,diff(i,j));
            }
        }
        if(min == 5001) min = -1;
        System.out.println(min);
    }

    public static int diff(int i, int j){
        int sum1 = arr[i]+arr[j];
        int sumTmp = sum - sum1;
        int abilityDiff = 5001;
        for(int k =0; k < 5; k++){
            if(k==i||k==j) continue;
            int sum2 = sumTmp - arr[k];   
            int sum3 = arr[k];            

            int max = Math.max(sum1, Math.max(sum2, sum3));
            int min = Math.min(sum1, Math.min(sum2, sum3));
            if(sum1 == sum2 || sum2 == sum3 || sum1==sum3) break;
            abilityDiff = Math.min(abilityDiff, max - min);
        }
        
        return abilityDiff;
    }
}