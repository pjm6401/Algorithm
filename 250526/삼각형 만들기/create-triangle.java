import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n-2;i++){
            for(int j = i+1; j<n-1; j++){
                for(int k = j+1; k<n; k++){
                    if(y[i] - y[j] == 0 || y[j]-y[k] == 0 || y[k]-y[i] ==0 &&
                        x[i] - x[j] == 0 || x[j]-y[k] == 0 || x[k]-y[i] ==0 ){
                            int minX = Integer.MAX_VALUE;
                            int minY = Integer.MAX_VALUE;
                            int maxX = Integer.MIN_VALUE;
                            int maxY = Integer.MIN_VALUE;

                            minX = Math.min(minX,Math.min(x[i],Math.min(x[j],x[k])));
                            maxX = Math.max(maxX,Math.max(x[i],Math.max(x[j],x[k])));
                            minY = Math.min(minY,Math.min(y[i],Math.min(y[j],y[k])));
                            maxY = Math.max(maxY,Math.max(y[i],Math.max(y[j],y[k])));

                            int length = maxX-minY;
                            int heigth = maxY-minY;

                            max = Math.max(max,length*heigth);
                        }
                }
            }
        }

        System.out.println(max);
    }
}