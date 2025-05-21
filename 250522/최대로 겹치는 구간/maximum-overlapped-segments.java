import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];

        int[] index = new int [200];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt()+100;
            x2[i] = sc.nextInt()+100;

            for(int k = x1[i];k<x2[i];k++){
                index[k]++;
            }
        }

        int max = 0;

        for(int i = 0; i<200; i++){
            if(index[i]>max) max = index[i];
        }

        System.out.println(max);


        // Please write your code here.
    }
}