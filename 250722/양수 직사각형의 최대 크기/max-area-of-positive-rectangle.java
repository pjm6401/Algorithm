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
        //x 9  y 6 
        int dy = y;
        
        for(int j = y; j<m; j++){
            if(grid[x][j]<=0) break;
            dy = j;
       
        }
        int aMin = 21;
        int bMin = 21;
        int bSize  = 0;
        int down = 0;
        for(int j = y; j<=dy; j++){
            int count = 0;
            for(int i = x; i<n; i++){
                if(grid[i][j]<=0){
                    break;
                } 
                if(j==y) down++;
                count ++;
            }
            aMin = Math.min(aMin,count);
        }

        for(int i = x; i<x+down;i++){
            int temp = 0;
            for(int j = y; j<=dy; j++){
                if(grid[i][j]<=0) break;
                temp++;
            }
            int heigth = i - x + 1;
            bMin = Math.min(bMin,temp);
            //if(x==9 && y==6) System.out.println(bMin*heigth);
            bSize = Math.max(bSize,bMin*heigth);
        }
        int aSize = aMin * (dy - y +1);  
        
        return Math.max(down,Math.max(aSize,bSize)); 
    }

}