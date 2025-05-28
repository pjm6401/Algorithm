import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int max = 0;
        for(int i = x; i<y; i++){

            int a = i /10000;
            int b = (i /1000) % 10;
            int c = (i / 100) % 10;
            int d = (i / 10) % 10;
            int e = i%10;
            
            max = Math.max(max,a+b+c+d+e);
        }
        System.out.println(max);
    }
}