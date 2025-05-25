import java.util.Scanner;
public class Main {

    static int length = 6;
    static int [] arr = new int[length];
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i =0; i<length; i++){
            arr[i] = sc.nextInt();
            sum +=arr[i];
        }

        int min = 6000001;

        for(int i =0; i<length-1; i++){
            for(int j=i+1; j<length; j++){
                min = Math.min(min,diff(i,j));
            }
        }
        System.out.println(min);
    }


    public static int diff(int i, int j){
        int sum1 = arr[i]+ arr[j];
        int sumTmp = sum - sum1;
        int minDiff = 6000001;
        for(int k = 0; k<length-1;k++){
            for(int l = k+1; l<length; l++){
                if(k==i || k==j || l==i || l==j) continue;
                int sum2 =arr[k]+arr[l];
                int sum3 = sumTmp - sum2;

                int max = Math.max(sum1,Math.max(sum2,sum3));
                int min = Math.min(sum1,Math.min(sum2,sum3));

                minDiff = Math.min(minDiff, max-min);
            }
        }

        return minDiff;
    }
}