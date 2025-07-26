import java.util.Scanner;

public class Main {
    static int n;
    static int [][] grid = new int [100][100];
    static boolean [][] visit = new boolean[100][100];
    static int blocks = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int boom = 0;
        int max = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(!visit[i][j]){
                    DFS(i,j);
                    if(blocks>=4) boom++;
                    max = Math.max(max,blocks);
                    blocks=0;
                }
            }
        }
        System.out.println(boom+" "+max);
            
    }


    public static void DFS(int x, int y){
        if(!visit[x][y]){
            visit[x][y] = true;
            blocks++;
            if(isRange(x+1,y,grid[x][y])) DFS(x+1,y);
            if(isRange(x-1,y,grid[x][y])) DFS(x-1,y);
            if(isRange(x,y+1,grid[x][y])) DFS(x,y+1);
            if(isRange(x,y-1,grid[x][y])) DFS(x,y-1);
        }
    }

    public static boolean isRange(int x, int y,int block){
        return (x>=0 && x<n && y>=0 && y<n && grid[x][y] == block);
    }
}