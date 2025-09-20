import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] matrix = new int [n+1][n+1];

        for(int i  = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                matrix[i][j] = 10000001;
                if(i==j) matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            matrix[u][v] = w;
        }
        

        for(int k =1; k<=n;k++){
            for(int i  = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i  = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                   if(i==j) continue;
                   min = Math.min(min, matrix[i][j] + matrix[j][i]);
            }
        }

        System.out.println(min);
    }
}