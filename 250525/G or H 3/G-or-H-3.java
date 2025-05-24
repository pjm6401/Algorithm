import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        char [] arr = new char [10001];

        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);

            arr[pos-1] = c;
        }
        int max = 0;
        for (int i = 0; i < 10000-k; i++) {
            int sum = 0;
            for(int j = i; j <= i+k; j++){
                int num = 0;
                if(arr[j] == 'G') num = 1;
                else if(arr[j] == 'H') num = 2;

                sum += num;
            }
            max = Math.max(max,sum);
        }
        System.out.print(max);
    }
}