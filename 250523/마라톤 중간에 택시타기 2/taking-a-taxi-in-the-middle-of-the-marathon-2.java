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
        int index = 1;
        int distance = 0;
        int xPoint = x[0];
        int yPoint = y[0];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j<n;j++){
                if(j==index) continue;
                int distanceX = Math.abs(xPoint-x[j]);
                int distanceY = Math.abs(yPoint-y[j]);
                distance = distance + distanceX + distanceY;
                xPoint = x[j];
                yPoint = y[j];
            }   
            index++;
            min = Math.min(min,distance);
            xPoint = x[0];
            yPoint = y[0];
            distance = 0;
        }
        System.out.println(min);
    }

}