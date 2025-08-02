import java.util.Scanner;
public class Main {
    static int n;
    static int r;
    static int c;
    static int [][] grid = new int[101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        shift(grid);
    }

    public static void shift(int [][] grid){
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        int x = r-1;
        int y = c-1;
        int tempX = x;
        int tempY = y;
        System.out.print(grid[x][y]+" ");
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i<4; i++){
                if(isRange(x+dx[i],y+dy[i]) && grid[x][y]< grid[x+dx[i]][y+dy[i]]){
                    tempX = x+dx[i];
                    tempY = y+dy[i];
                    flag = true;
                }
            }
            if(flag){
                x = tempX;
                y = tempY;
                System.out.print(grid[x][y]+" ");
            }
        }
        
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }
}