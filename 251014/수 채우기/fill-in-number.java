import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int limit = n/2;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<=limit; i++){
            int last = n - (2*i);

            int cnt = last/5;

            last -= last/5 * 5;

            if(last == 0){
                min = Math.min(min,i+cnt);
            }
            
        }

        if(min == Integer.MAX_VALUE) min = -1;

        System.out.println(min);
    }
}