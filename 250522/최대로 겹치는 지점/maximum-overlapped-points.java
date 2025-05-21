import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] index = new int [100];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt()-1;
            int end = sc.nextInt()-1;

            for(int k = start; k<=end;k++){
                index[k]++;
            }
        }

        int max = 0;

        for(int i = 0; i<100; i++){
            if(index[i]>max) max = index[i];
        }
        System.out.println(max);
    }
}