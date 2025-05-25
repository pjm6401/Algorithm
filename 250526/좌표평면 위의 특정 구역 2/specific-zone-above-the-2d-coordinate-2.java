import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE;
            for(int j = 0; j<N; j++){
                if(i==j) continue;
                maxX = Math.max(maxX,x[j]);
                maxY = Math.max(maxY,y[j]);
                minX = Math.min(minX,x[j]);
                minY = Math.min(minY,y[j]);
            }

            min = Math.min(min,(maxX-minX) * (maxY-minY));
        }

        System.out.println(min);
    }
}