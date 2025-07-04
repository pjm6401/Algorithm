import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<=10000; i++){
            int num = i;
            boolean flag = true;
            for(int j = 0; j < n; j++){
                num *=2;

                if(!(a[j]<=num && b[j]>= num)){
                    flag = false;
                    break;
                }
            }
            if(flag) min = Math.min(min,i);  
        }
        System.out.println(min);
    }
}