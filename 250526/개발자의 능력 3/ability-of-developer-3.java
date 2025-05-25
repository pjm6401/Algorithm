import java.util.Scanner;

public class Main {

    static int[] ability = new int[6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            ability[i] = sc.nextInt();
            sum+=ability[i];
        }

        int min = sum;
        
        for(int i =0; i<4; i++){
            for(int j =i+1; j<5; j++){
                for(int k = j+1; k<6; k++){
                    int sum1 = ability[i]+ability[j]+ability[k];
                    int sum2 = sum - sum1;

                    int diff = Math.abs(sum1-sum2);

                    min = Math.min(min,diff);
                }
            }
        }
        System.out.println(min);
    }
}