import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 3;

    public static int n = MAX_N;
    public static int[] a = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();


        Arrays.sort(a);


        if(a[0] + 1 == a[1] && a[1] + 1 == a[2])
            System.out.print(0);
 
        else if(a[0] + 2 == a[1] || a[1] + 2 == a[2])
            System.out.print(1);

        else
            System.out.print(2);
    }
}
