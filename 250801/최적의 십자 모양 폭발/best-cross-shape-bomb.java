import java.util.Scanner;

public class Main {
    static int n;
    static int [][] grid = new int [51][51];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int max = -1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int [][] temp = copyGrid(grid);
                temp = boom(i,j,temp);
                max = Math.max(max,pairCount(temp));
            }
        }

        System.out.println(max);           
        
    }
    public static int [][] boom(int x, int y, int [][]grid){
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        int boomRange = grid[x][y]-1;
        grid[x][y] = 0;
        for(int i = 0; i<4; i++){
            int tx = x;
            int ty = y;
            for(int j =0; j<boomRange; j++){
                if(isRange(tx+dx[i],ty+dy[i])){
                    tx+=dx[i];
                    ty+=dy[i];
                    grid[tx][ty] = 0;
                }
            }
        }
        return shift(grid);
    }

    public static int pairCount(int [][] grid){
        int count = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(isRange(i,j+1) && grid[i][j] == grid[i][j+1] && grid[i][j+1]!=0){
                    count++;
                }
                if(isRange(i+1,j) && grid[i][j] == grid[i+1][j] && grid[i+1][j]!=0){
                    count++;
                }
            }
        }
        return count;
    }
    public static int [][] shift(int [][] grid){
        int [][] temp = new int [n][n];

        for(int j=n-1; j>=0; j--){
            int index = n-1;
            for(int i = n-1; i>=0; i--){
                if(grid[i][j] !=0){
                    temp[index--][j] = grid[i][j];
                }
            } 
        }
        return temp;
    }
    public static boolean isRange(int x, int y){
        return(x>=0 && x<n && y>=0 && y<n);
    }
    public static int[][] copyGrid(int[][] grid) {
        int[][] temp = new int[n][n];
        for(int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }

}