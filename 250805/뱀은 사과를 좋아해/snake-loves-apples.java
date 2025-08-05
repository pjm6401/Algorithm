import java.util.*;

class state{
    int x;
    int y;

    public state(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}

public class Main {
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int m; 
    static int n;
    static int k;
    static int [][] grid = new int [101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            grid[x][y] = 1;
        }
        int startX = 0;
        int startY = 0;
        int time = 0;
        boolean [][] visit = new boolean[n][n];
        Deque<state> dq = new ArrayDeque<>();
        state start = new state(startX,startY);
        dq.push(start);

        for (int i = 0; i < k; i++) {
            char d = sc.next().charAt(0);
            int p = sc.nextInt();
            int dir = getDir(d);
            boolean flag = true;
            for(int j = 0; j<p; j++){
                int nx = startX+dx[dir];
                int ny = startY+dy[dir];
                time++;
                if(isRange(nx,ny) && !visit[nx][ny]){
                    startX = nx;
                    startY = ny;
                    if(grid[nx][ny] == 1){
                        visit[nx][ny] = true;
                        state newState = new state(nx,ny);
                    }else{
                        visit[nx][ny] = true;
                        state newState = new state(nx,ny);
                        dq.push(newState);
                        state oldState = dq.pop();
                        visit[oldState.getX()][oldState.getY()] = false;
                    }
                }else{
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }
        System.out.println(time);
    }
    public static int getDir (char d){
        int dir = 0;

        if(d =='R') dir = 0;
        else if(d == 'D') dir = 1;
        else if(d == 'L') dir = 2;
        else dir = 3;

        return dir;
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }
}