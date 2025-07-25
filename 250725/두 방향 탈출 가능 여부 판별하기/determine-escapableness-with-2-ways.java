import java.util.Scanner;
public class Main {

    static int result = 0;
    static int n;
    static int m;
    static boolean [][] visited = new boolean[101][101];
    static int [][] grid = new int[101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        if(grid[0][0] == 0) {
            System.out.println(0);
            return;
        }

        DFS(0,0);
        System.out.println(result);
    }

    public static void DFS(int x, int y){
        if(grid[x][y] == 1 && !visited[x][y]){
            
            visited[x][y] = true;
            if(x==0 && y == 0) {
                DFS(x+1,y);
                DFS(x,y+1);
            }else{
                if(isXRange(x-1,y) || isYRange(x,y-1)){
                    if(x==n-1&&y==m-1) {
                        result =1;
                    }
                    if(isRange(x+1,y)) DFS(x+1,y);
                    if(isRange(x,y+1)) DFS(x,y+1);
                    
                }
            }
        }
    }

    public static boolean isXRange(int x,int y){
        return (x>=0 && x<n && visited[x][y]);
    }
    public static boolean isYRange(int x,int y){
        return (y>=0 && y<n && visited[x][y]);
    }
    public static boolean isRange(int x,int y){
        return (y>=0 && y<n && x>=0 && x<n);
    }
}