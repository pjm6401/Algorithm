import java.util.*;
public class Main {

    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static Deque<Index> dq = new ArrayDeque<>();
    static int ans = 0;
    static ArrayList<Index> list = new ArrayList<>();
    static int [][] grid = new int[100][100];
    static int n;
    static int k;
    static boolean [][] visit = new boolean[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            list.add(new Index(x,y));
        }
        
        for(int i = 0; i < list.size(); i++){
            Index index = list.get(i);
            if(!visit[index.x][index.y]){
                visit[index.x][index.y] = true;
                ans++;
            }
            dq = new ArrayDeque<>();
            dq.add(index);
            BFS();
        }
        System.out.println(ans);
    }

    public static void BFS(){
        while(!dq.isEmpty()){
            Index index = dq.poll();
            int x = index.x;
            int y = index.y;

            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(isRange(nx,ny) && !visit[nx][ny] && grid[nx][ny] == 0){
                    visit[nx][ny] = true;
                    ans++;
                    dq.add(new Index(nx,ny));
                }
            }
        }
    }

    public static boolean isRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }
}

class Index{
    int x;
    int y;

    public Index (int x, int y){
        this.x = x;
        this.y = y;
    }
}