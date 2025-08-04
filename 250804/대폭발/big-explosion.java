import java.util.Scanner;

public class Main {

    static boolean [][] visit = new boolean[101][101];
    static boolean [][] currentVisit = new boolean[101][101];
    static int [][] grid = new int [101][101];
    static int n;
    static int m;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        int time =0;
        grid[r][c] = 1;
        visit[r][c] = true;
        time++;
        while(time<=m){
            currentVisit = new boolean[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(visit[i][j]){
                        
                        int length = (int) Math.pow(2, time-1); // 8
                        currentVisit[i][j] = true;
                        for(int k = 0; k<4; k++){
                            int nx = i+dx[k]*length;
                            int ny = j+dy[k]*length;
                            if(isRange(nx,ny) && !currentVisit[nx][ny]){
                                grid[nx][ny] = 1;
                                //visit[nx][ny] = true;
                                currentVisit[nx][ny]= true;
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(currentVisit[i][j]) visit[i][j] = true;
                }
            }
            time++;
        }
        int cnt = 0;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==1) cnt++;
                //System.out.print(grid[i][j] + " ");
            }
            //System.out.println();
        }
        
        System.out.println(cnt);
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n );
    }
}