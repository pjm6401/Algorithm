import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = 0;
        Arrays.sort(nums);


        for(int i = 0; i<2*n; i+=2){
            max = Math.max(max, nums[i+1] - nums[i]);
        }

        System.out.println(max);
    }
}
