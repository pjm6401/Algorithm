import java.util.*;
public class Main {

    static int n;
    static int m;
    static int t;
    static int[][] grid = new int[20][20];
    static boolean [][] visit = new boolean [20][20];
    static Deque<int []> dq = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int [][] temp = new int [n][n];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            visit[x][y] = true;
            dq.add(new int [] {x,y});
            temp[x][y] = 1;
        }
        int [] dx = {0,0,1,-1};
        int [] dy = {-1,1,0,0};
        for(int i = 0; i<t; i++){
            for(int k = 0; k < dq.size(); k++){
                int [] arr = dq.poll();
                int x = arr[0];
                int y = arr[1];
                if(!visit[x][y]) continue;
                int tx = x;
                int ty = y;
                int now = grid[x][y];
                int max = grid[x][y];

                for(int j = 0; j<4; j++){
                    int nx = x+dx[j];
                    int ny = y+dy[j];

                    if(isRange(nx,ny) && grid[nx][ny] >= max){
                        max = grid[nx][ny];
                        tx = nx;
                        ty = ny;
                    }
                }
                if(now != max){
                    temp[tx][ty] +=1;
                    temp[x][y] -=1;
                    visit[tx][ty] = true;
                    visit[x][y] = false;
                    dq.add(new int[]{tx,ty});
                }
            }
            temp = newGrid(temp);
        }

        System.out.println(clacBall(temp));
    }
    public static boolean isRange(int x, int y){
        return( x>=0 && x<n && y>=0 && y<n);
    }

    public static int [][] newGrid(int [][] grid){
        int [][] temp = new int [n][n];
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = grid[i][j];
                if(temp[i][j] >=2) {
                    temp[i][j] = 0;
                    visit[i][j] = false;
                }
            }
        }

        return temp;
    }

    public static int clacBall(int [][]grid){
        int cnt = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                
                if(grid[i][j] ==1) cnt++;
            }
        }
        return cnt;
    }
}