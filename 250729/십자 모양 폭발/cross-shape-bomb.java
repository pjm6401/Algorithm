import java.util.Scanner;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        grid = boom(r,c,grid);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static int [][] boom(int x, int y,int[][] grid){
        int [][] tempGrid = new int [n][n];
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        x -=1;
        y -=1;


        int bomb = grid[x][y];
        int bombRange = bomb -=1;
        grid[x][y] = 0;
        for (int dir = 0; dir < 4; dir++) {
            int tx = x;
            int ty = y;
            for (int i = 0; i < bombRange; i++) {
                tx += dx[dir];
                ty += dy[dir];
                if (!isRange(tx, ty)) break;
                grid[tx][ty] = 0;
            }
        }

        for(int i = n-1;i>=0; i--){
            int index = n-1;
            for(int j = n-1; j>=0; j--){ 
                if(grid[j][i]!=0){
                    tempGrid[index][i] = grid[j][i];
                    index--;
                }
            }
        }



        return tempGrid;
    }
}