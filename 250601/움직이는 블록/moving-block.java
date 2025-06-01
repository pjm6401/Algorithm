import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
            sum += blocks[i];
        }

        int mean = sum / n;
        int cnt = 0;

        for(int i = 0; i<n; i++){
            if(blocks[i]<=mean) continue;
            cnt += blocks[i] - mean;
        }

        System.out.println(cnt);
    }
}