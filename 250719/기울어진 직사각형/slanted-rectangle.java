import java.util.Scanner;
public class Main {

    static int n;
    static int [] dx = {-1,-1,0,1,1,1,0,-1};
    static int [] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] grid = new int[n][n];
        boolean [][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int max = 0;
        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < n-1; j++){
                max = Math.max(calc(grid,i,j,visit),max);
            }
        }
        System.out.println(max);
    }

    public static int calc(int [][] grid, int i , int j, boolean [][] visit){
        if (visit[i][j]) return 0;
        int dxA = i+dx[0];
        int dyA = j+dy[0];
        int dxB = i+dx[2];
        int dyB = j+dy[2];
        int dxC = i+dx[4];
        int dyC = j+dy[4];
        int dxD = i+dx[6];
        int dyD = j+dy[6];
        int sumA = grid[dxA][dyA] + grid[dxB][dyB] + grid[dxC][dyC] + grid[dxD][dyD];
        int sumB = grid[dxA][dyA] + grid[dxB][dyB] + grid[dxC][dyC] + grid[dxD][dyD];
        visit[i][j] = true;
        
        boolean flag1 = true;
        boolean flag2 = true;
        while(flag1 || flag2){
            if(dxA+dx[1]>=0 && dyB+dy[1]<n){
                dxA+=dx[1];
                dyA+=dy[1];
                dxB+=dx[1];
                dyB+=dy[1];
                sumA += grid[dxA][dyA] + grid[dxB][dyB];
                visit[dxB][dyB-1] = true;
            }else if(dxC+dx[5]<n && dyD+dy[5]>=0){
                dxC+=dx[5];
                dyC+=dy[5];
                dxD+=dx[5];
                dyD+=dy[5];
                sumA += grid[dxC][dyC] + grid[dxD][dyD];
                visit[dxD][dyD+1] = true;
            }else{
                flag1 = false;
            }

            if(dxA+dx[7]>=0 && dyD+dy[7]>=0){
                dxA+=dx[7];
                dyA+=dy[7];
                dxD+=dx[7];
                dyD+=dy[7];
                sumB += grid[dxA][dyA] + grid[dxD][dyD];
                visit[dxD][dyD+1] = true;
            }else if(dyB+dy[3]<n && dxC+dx[3]>=0){
                dxB+=dx[3];
                dyB+=dy[3];
                dxC+=dx[3];
                dyC+=dy[3];
               
                sumB += grid[dxB][dyB] + grid[dxC][dyC];
                visit[dxB][dyB-1] = true;
            }else{
                flag2 = false;
            }
        }
        return Math.max(sumA,sumB);
    }
    
}