import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(long i = a; i<=b; i++){
            long x = i;
            int cnt = 0;
            long left = 1;
            long right = m;

            while(left<=right){
                long mid = (left+right)/2;
                cnt ++;
                if(mid == x){
                    break;
                }

                if(mid > x){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
                
            }
            min = Math.min(min,cnt);
            max = Math.max(max,cnt);

        }
        System.out.println(min+" "+max);
    }
}