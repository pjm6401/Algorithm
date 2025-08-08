import java.util.*;
public class Main {

    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int n;
    static int m;
    static int [][] grid = new int [100][100];
    static boolean [][] visit = new boolean[100][100];
    static Deque<Index> dq = new ArrayDeque<>();
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        dq.add(new Index(0,0));
        visit[0][0] = true;
        BFS();

        System.out.println(answer);
    }
    
    public static void BFS(){
        while(!dq.isEmpty()){
            Index index = dq.poll();
            int x = index.x ;
            int y = index.y ;
            if(index.x == n-1 && index.y == m-1 && grid[x][y] ==1){
                answer = 1;
                return;
            }
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(isRange(nx, ny) && !visit[nx][ny] && grid[x][y] ==1){
                    visit[nx][ny]=true;
                    dq.add(new Index(nx,ny));
                }
            }
        }
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<m);
    }
    
}
class Index{
    int x;
    int y;
    public Index(int x, int y){
        this.x = x;
        this.y = y;
    }
}