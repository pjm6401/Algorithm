import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long left = 1;
        long right = (long)Math.sqrt(2 * (double)s) + 2; // 상한 제한
        long min = 0;
        while(left<=right){
            long mid = (left+right)/2;

            if (mid <= (2 * s) / (mid + 1)) {
                left = mid +1;
                min = Math.max(min,mid);
            }else{
                right = mid - 1;
            }
        }
        System.out.println(min);
    }
}