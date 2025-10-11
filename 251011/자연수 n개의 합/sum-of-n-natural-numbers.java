import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long left = 1;
        long right = Long.MAX_VALUE;
        long min = 0;
        while(left<=right){
            long mid = (left+left)/2;

            if(mid * (mid+1) / 2 <= s){
                left = mid +1;
                min = Math.max(min,mid);
            }else{
                right = mid - 1;
            }
        }
        System.out.println(min);
    }
}