import java.util.Scanner;
public class Main {

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int index = 0;
        for (int i = 0; i < n; i++){
            int sum = 0;
            for(int j =0; j<n; j++){
                if(j==i) continue;

                int roomDistance = (j-i+n) % n;
                sum += (roomDistance*arr[j]);
            }
            min = Math.min(min,sum);
        }
        System.out.println(min);
    }
}