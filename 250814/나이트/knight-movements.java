import java.util.*;
public class Main {

    static int n;
    static int r1;
    static int c1;
    static int r2;
    static int c2;

    static int [] dx = {-2,-1,1,2,2,1,-1,-2};
    static int [] dy = {1,2,2,1,-1,-2,-2,-1};
    static Deque<Index> dq = new ArrayDeque<>();
    static boolean [][] visit = new boolean[100][100];
    static int [][] step = new int [100][100];
    static int min = 10000;
    static int ans = min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;
        dq.add(new Index(r1,c1));
        step[r1][c1] = 0;
        BFS();
        if(ans == min){
            ans = -1;
        }

        System.out.println(ans);
    }

    public static void BFS(){
        while(!dq.isEmpty()){
            Index index = dq.poll();

            int x = index.x;
            int y = index.y;
            visit[x][y] = true;

            if(x==r2 && y==c2){
                ans = Math.min(ans,step[x][y]);
                break;
            }

            for(int i = 0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i]; 

                if(isRange(nx,ny)){
                    dq.add(new Index(nx,ny));
                    step[nx][ny] = step[x][y] + 1;
                }
            }
            
        }
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n && !visit[x][y]);
    }
}
class Index {
    int x;
    int y;
    public Index(int x, int y){
        this.x = x;
        this.y = y;
    }
}