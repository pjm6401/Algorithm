import java.util.*;

public class Main {
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]<=0) continue; 

                int recCount = countRec(i,j,grid);

                count = Math.max(count,recCount);
            }
        }
        if(count == 0 ) count = -1;

        System.out.println(count);
    }

    public static int countRec(int x, int y, int [][]grid){
        
        int dy = y;

        for(int j = y; j<m; j++){
            if(grid[x][j]<=0) break;
            dy = j;
        }
       
        int min = 21;
        int down = 0;
        for(int j = y; j<=dy; j++){
            int count = 0;
            for(int i = x; i<n; i++){
                if(grid[i][j]<=0) break;
                if(j==y) down++;
                count ++;
                
            }
            min = Math.min(min,count);
        }

        int size = min * (dy - y +1);
        return Math.max(down,size); 
    }

}