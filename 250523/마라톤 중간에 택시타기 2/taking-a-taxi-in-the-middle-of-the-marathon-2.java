import java.util.Scanner;

public class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }


        for (int i = 1; i < n-1; i++) {
            int xPoint = x[0];
            int yPoint = y[0];
            int distance = 0;
            for(int j = 1; j<n;j++){
                if(j==i) continue;
                int distanceX = Math.abs(xPoint-x[j]);
                int distanceY = Math.abs(yPoint-y[j]);
                distance = distance + distanceX + distanceY;
                xPoint = x[j];
                yPoint = y[j];
            }   
            min = Math.min(min,distance);
        }
        System.out.println(min);
    }

}