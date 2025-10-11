import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long left = 1;
        long right = Long.MAX_VALUE-1;

        long result = 0;

        while(left<=right){
            long mid = (left+right) /2;

            if(flag(mid) == n){
                result = mid;
                break;
            }else if(flag(mid)<n){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        System.out.println(result);
    }

    public static long flag(long n){
        long three = n/3;
        long five = n/5;

        long fifteen = n/15;

        return n-three-five+fifteen;
    }
}