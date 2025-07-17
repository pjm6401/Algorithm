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

        
        if(m==1){
            System.out.println(n*2);
            return;
        }
        int count = 0;


        for(int i = 0; i <n; i++){
            int rCount = m-1;
            int cCount = m-1;
            boolean rowCheck = false;
            boolean colCheck = false;
            for(int j = 0; j<n-1; j++){
                if(grid[i][j] == grid[i][j+1]) {
                    rCount --;
                    
                }else{
                    rCount = m-1;
                }

                if(rCount == 0) {
                        rowCheck = true;
                }
                if(grid[j][i] == grid[j+1][i]) {
                    cCount --;
                    
                }else{
                    cCount = m-1;
                }
                if(cCount == 0) {
                        colCheck = true;
                    }
            }
            if(colCheck) count++;
            if(rowCheck) count++;
        }
        System.out.println(count);
    }
}