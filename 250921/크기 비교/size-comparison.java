import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int [][] matrix = new int [n+1][n+1];

        for(int i = 0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            matrix[x][y] = 1;
        }
        for(int k=1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(matrix[i][k] == 1 && matrix[k][j]==1) matrix[i][j] = 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            int unknownCount = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue; 

                if (matrix[i][j] == 0 && matrix[j][i] == 0) {
                    unknownCount++;
                }
            }
            System.out.println(unknownCount);
        }
    }
}