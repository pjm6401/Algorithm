import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int max = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n-2; j++){
                max = Math.max(max,grid[i][j]+grid[i][j+1]+grid[i][j+2]);
            }
        }
            
        System.out.println(max);
        
       
    }
}