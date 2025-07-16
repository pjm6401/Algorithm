import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int count = 0;
        for(int i = 0; i <n; i++){
            int rCount = m-1;
            int cCount = m-1;
            for(int j = 0; j<n-1; j++){
                if(grid[i][j] == grid[i][j+1]) rCount --;

                if(grid[j][i] == grid[j+1][i]) cCount --;
            }
            if(cCount<=0) count++;
            if(rCount<=0) count++;
        }
        System.out.println(count);
    }
}