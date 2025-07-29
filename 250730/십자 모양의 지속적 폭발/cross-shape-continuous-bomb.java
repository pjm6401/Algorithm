import java.util.Scanner;
public class Main {
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[] bombCols = new int[m];
        for (int i = 0; i < m; i++)
            bombCols[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            grid = boom(bombCols[i]-1,grid);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
            
    }

    public static int [][] boom(int col, int [][] grid){
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        

        for(int j = 0; j<n; j++){
            if(grid[j][col] != 0){
                int boomRange = grid[j][col]-1;
                for(int i = 0; i < 4; i++){
                    int x = j;
                    int y = col;
                    for(int k = 0; k<boomRange; k++){
                        if(isRange(x+dx[i],y+dy[i])){
                            x +=dx[i];
                            y +=dy[i];
                            grid[x][y] = 0;
                        }
                    }
                }
                grid[j][col] = 0;
                grid = shift(grid);
                
                break;
            }
        }
        
        return grid;
    }

    public static int [][] shift(int [][] grid){
        int [][] temp = new int [n][n];

        for(int j = n-1; j>=0; j--){
            int idx = n-1;
            for(int i = n-1; i>=0; i--){
                if(grid[i][j]!=0){
                    temp[idx][j] = grid[i][j];
                    idx--;
                }
            }
        }
        return temp;
    }
    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }
}